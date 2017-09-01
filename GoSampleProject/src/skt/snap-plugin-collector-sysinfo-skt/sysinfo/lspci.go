package sysinfo

import (
	_ "fmt"
	"log"
	"os/exec"
	"bytes"
    "strings"
    "github.com/intelsdi-x/snap-plugin-lib-go/v1/plugin"
)

// lspci
var pciMetricPrefixs = []string{"skt", "custom", "pci"}

func GetPciData() []map[string]string {
	if IsVirtual() {
		return nil
	}
	
	lineStrings, _ := GetLineStrings("lspci", "-v", "-mm", "-k")	
	dataMapList := []map[string]string{}
	dataMap := map[string]string{}
	
	for _, line := range lineStrings {
		if len(strings.TrimSpace(line)) >= 3 {
			sp := strings.SplitN(line, ":", 2)
			key := strings.TrimSpace(sp[0])
			val := strings.TrimSpace(sp[1])
			
			dataMap[key] = val
		} else {
			if val, ok := dataMap["Class"]; ok {
				if strings.Contains(val, "RAID") || strings.Contains(val, "Ethernet") {
					dataMapList = append(dataMapList, dataMap)
				}
			}
			
			dataMap = map[string]string{}
		}
	}
	
	return dataMapList
}

/*
	VM 환경인지 확인
	1. virt-what 명령어로 확인. 가상머신이 아닌경우 리턴값 없음
	2. lscpu 명령어로 확인. 가상머신인 경우 Hypervisor 필드가 있음
*/
func IsVirtual() bool {
	_, err := exec.LookPath("virt-what")
	
	if err == nil {
		 cmd := exec.Command("virt-what")
		 
		 var outb, errb bytes.Buffer

		 cmd.Stdout = &outb
		 cmd.Stderr = &errb
		 
		 err := cmd.Run()
		 if err == nil {
		 	if len(strings.TrimSpace(outb.String())) > 1 {
			 	return true
		 	} else {
			 	return false
		 	}
		 }
	}
	
	_, err = exec.LookPath("lscpu")
	
	if err == nil {
		 cmd := exec.Command("lscpu")
		 
		 var outb, errb bytes.Buffer

		 cmd.Stdout = &outb
		 cmd.Stderr = &errb
		 
		 err := cmd.Run()
		 if err == nil {
		 	if strings.Contains(outb.String(), "Hypervisor") {
			 	return true
		 	} else {
			 	return false
		 	}
		 }
	} else {
		log.Fatal(err)
	}
	
	return false
}

func GetLspciInfoToMetrics() []plugin.Metric {
	metrics := []plugin.Metric{}
	pciInfo := GetPciData()
	
	for _, info := range pciInfo {
		namespace := append(pciMetricPrefixs, strings.ToLower(strings.Replace(info["Class"], " ", "_", -1)))
		var tag = map[string]string{"vendor":info["Vendor"], "slot":info["Slot"]}
		
		if strings.Contains(info["Class"], "RAID") {
			tag["driver"] = info["Driver"]
		} else {
			tag["device"] = info["Device"]
		}
		
		metrics = append(metrics,
			plugin.Metric{
				Namespace: plugin.NewNamespace(namespace...),
				Tags: tag,
				Data: info["Slot"],
		})
	}
	
	return metrics
}

/*
func main() {
	fmt.Println(GetPciData())
}
*/