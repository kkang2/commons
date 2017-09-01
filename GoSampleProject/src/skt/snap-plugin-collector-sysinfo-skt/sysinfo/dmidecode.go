package sysinfo

import (
	"fmt"
    "strings"
    "github.com/intelsdi-x/snap-plugin-lib-go/v1/plugin"
)

// dmidecode
var dmiMetricPrefixs = []string{"skt", "custom", "dmi", "memory"}
var CHECK_MAP_KEYS = []string{"Size"}

func GetDmiData() []map[string]string {
	lineStrings, _ := GetLineStrings("dmidecode", "--type", "memory")
	dataMapList := []map[string]string{}
	dataMap := map[string]string{}
	
	isMapData := false
	
	for _, line := range lineStrings {
		line = strings.TrimSpace(line)
		
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

func GetDmidecodeToMetrics() []plugin.Metric {
	metrics := []plugin.Metric{}
	dmiInfo := GetDmiData()
	
	for _, info := range dmiInfo {
		var tag = map[string]string{"form_factor":info["Form Factor"],
			"locator":info["Locator"],
			"type":info["Type"],
			"speed":info["Speed"],
			"manufacturer":info["Manufacturer"],
			"serial_number":info["Serial Number"],
			"asset_tag":info["Asset Tag"],
			"part_number":info["Part Number"],
			"configured_clock_speed":info["Configured Clock Speed"],
		}
		
		metrics = append(metrics,
			plugin.Metric{
				Namespace: plugin.NewNamespace(dmiMetricPrefixs...),
				Tags: tag,
				Data: info["Size"],
		})
	}
	
	return metrics
}

func main() {
	fmt.Println(GetDmiData())
}