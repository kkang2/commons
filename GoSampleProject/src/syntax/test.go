package main

import (
	"fmt"
	"log"
	"os/exec"
	"bytes"
    "strings"
)

var CHECK_MAP_KEYS = []string{"Size"}

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

func GetDmiData() []map[string]string {
	lineStrings, _ := GetLineStrings("dmidecode", "--type", "memory")
	dataMapList := []map[string]string{}
	dataMap := map[string]string{}
	
	isMapData := false
	
	for _, line := range lineStrings {
		line = strings.TrimSpace(line)
		
		//fmt.Println("line : " + line)
		
		if strings.Contains(line, "Memory Device") && len(line) == 13 {
			isMapData = true
			continue
		} else if len(line) == 0 {
			
			if len(dataMap) > 0 && isValidMap(dataMap) {
				dataMapList = append(dataMapList, dataMap)
				dataMap = map[string]string{}
			}
			
			isMapData = false
			continue
		}
		
		if isMapData && strings.Contains(line, ":") {
			sp := strings.SplitN(line, ":", 2)
			key := strings.TrimSpace(sp[0])
			val := strings.TrimSpace(sp[1])
			
			dataMap[key] = val
		}
	}
	
	if len(dataMap) > 0 && isValidMap(dataMap) {
		dataMapList = append(dataMapList, dataMap)
	}
	
	return dataMapList
}

func isValidMap(data map[string]string) bool {
	for _, key := range CHECK_MAP_KEYS {
		val, ok := data[key]
		
		if !ok || strings.ToLower(val) == "no module installed" {
			return false
		}
	}
	
	return true
}

func main() {
	fmt.Println(GetDmiData())
	fmt.Println(len(GetDmiData()))
}