package sysinfo

import (
    "fmt"
    "bytes"
    "log"
    "os/exec"
    "strings"
)

type SmartData struct {
    Key         string
    Value       string
}

type DeviceInfo struct {
    Name        string
    NumSmart    int
    Smart       []SmartData
}

func SetUserCapacity(s string) string {
    start := strings.Index(s, "[") + 1
    end   := strings.Index(s, "]")

    if end > start {
        return s[start:end]
    } else {
        fmt.Printf("TB position ???(start=%d, end=%d)\n", start, end)
    }

    return s
}

func GetLineStrings(c string, arg ...string) ([]string, int) {
    cmd := exec.Command(c, arg...)
    var outb, errb bytes.Buffer

    cmd.Stdout = &outb
    cmd.Stderr = &errb

    err := cmd.Run()
    if err != nil {
        log.Fatal(err)
    }

    lineStrings := strings.SplitAfter(outb.String(), "\n")

    return lineStrings, len(lineStrings)
}

func GetSmartData(d *DeviceInfo) {
    lineStrings, numLine := GetLineStrings("smartctl", "-i", d.Name)

    d.Smart = make([]SmartData, numLine)

    for _, line := range lineStrings {
        if strings.Contains(line, "http") {
            continue
        }
        for i, search := range line {
            if (search == ':') {
                d.Smart[d.NumSmart].Key = strings.Replace(line[:i], " ", "_", -1)
                d.Smart[d.NumSmart].Value = strings.Join(strings.Fields(line[i+1:len(line)]), " ")
                if strings.Contains(d.Smart[d.NumSmart].Key, "Capacity") {
                    d.Smart[d.NumSmart].Value = SetUserCapacity(d.Smart[d.NumSmart].Value)
                }
                d.NumSmart++
                break
            }
        }
    }
}

func GetDeviceNames() ([]string, int) {
    lineStrings, numLine := GetLineStrings("smartctl", "--scan")
    devNames := make([]string, numLine)
    numDev := 0

    for _, line := range lineStrings {
        if !strings.Contains(line, "/dev") {
           continue
        }
        for i, search := range line {
            if (search == ' ') {
                devNames[numDev] = line[:i]
                numDev++
                break
            }
        }
    }
    return devNames, numDev
}

func GetDeviceInfo() []DeviceInfo {
    devNames, numDev := GetDeviceNames()

    dev := make([]DeviceInfo, numDev)

    for i := 0; i < numDev; i++ {
        dev[i].Name = devNames[i]
        GetSmartData(&dev[i])
    }

    return dev
}

/*
func main() {
    dev := GetDeviceInfo()
    for _, d := range dev {
        fmt.Println("Device_Name:", d.Name)
        for i, s := range d.Smart {
            if (i >= d.NumSmart) {
                break;
            }
            fmt.Println(s.Key, "\t", s.Value)
        }
    }
}
*/
