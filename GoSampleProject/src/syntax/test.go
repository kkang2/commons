package main

import (
	"fmt"
    "strings"
    "os/exec"
    "log"
    "bytes"
    "time"
    _ "strconv"
)

/*
nvidia-smi --query-gpu=timestamp,driver_version,count,gpu_name,serial,uuid,vbios_version,fan.speed,pstate,memory.total,memory.used,memory.free,utilization.gpu,utilization.memory,temperature.gpu,power.management,power.draw,power.limit,power.default_limit,enforced.power.limit,power.min_limit,power.max_limit --format=csv
1. GPU Part Number
2. Utilization Encoder, Decoder
3. Temperature GPU Shutdown Temp, GPU Slowdown Temp
*/

var smiMetrics = []string{
	"uuid", "timestamp", "driver_version", "count", "gpu_name",
	 "serial", "vbios_version", "fan.speed","pstate","memory.total",
	"memory.used", "memory.free", "utilization.gpu","utilization.memory","temperature.gpu",
	"power.management", "power.draw", "power.limit","power.default_limit","enforced.power.limit",
	"power.min_limit", "power.max_limit",
}

func main() {
	start := time.Now()
	
	time.Sleep(time.Second * 1)
	
	fmt.Println("Elapsed Time:",time.Now().Sub(start))
}

func GetSmiData() []string {
	dataList := []string{}
	uuidStrings, _ := GetLineStrings("nvidia-smi", "--query-gpu=uuid", "--format=csv,noheader")
	
	for _, uuid := range uuidStrings {
		if len(uuid) > 1 {
			line, _ := GetLineStrings("nvidia-smi", "-i", strings.Trim(uuid, "\n"),
				 "--query-gpu=uuid,timestamp,driver_version,count,gpu_name,serial,vbios_version,fan.speed,pstate,memory.total,memory.used,memory.free,utilization.gpu,utilization.memory,temperature.gpu,power.management,power.draw,power.limit,power.default_limit,enforced.power.limit,power.min_limit,power.max_limit", "--format=csv,noheader")
			
			dataList = append(dataList, strings.Trim(line[0], "\n"))
		}
	}
	
	return dataList
}

/*
	커맨드 실행결과를 개행문자로 잘라서 스트링슬라이스 와 총갯수를 리턴한다.
*/
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