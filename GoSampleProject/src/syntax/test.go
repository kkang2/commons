package main

import (
	"fmt"
    _"strings"
)

func main() {
	var namespace []string
	tt := []string{"skt", "hwinfo", "disk"}
	
	namespace = append(namespace, tt...)
	
	fmt.Println(namespace)
	
	//args := strings.Split("-d megaraid,0 /dev/sda", " ")
	
	
	//fmt.Println(strings.Split("megaraid,0", ","))
	/*
	if len(args) == 3 {
		fmt.Println(args[0])
		fmt.Println(strings.Split(args[2][1:], "/"))
		fmt.Println(args[2])
	}
	*/
	//args = append(args, strings.Split("-d megaraid,0 /dev/sda", " ")...)
	
	//fmt.Println(args)
	
	//arg(args...)
}

func arg(arg ...string) {
	fmt.Println("==== 값 출력 ====")
	for _, val := range arg {
		fmt.Println(val)
	}
	
	fmt.Println(len(arg))
}

/*
var lines = []string{
		"/dev/sda -d scsi # /dev/sda, SCSI device",
	}
	
	devNames := make([]string, len(lines))
    numDev := 0
    
    diskName := ""
    raidCount := -1
	
	for _, line := range lines {
		 if !strings.Contains(line, "/dev") {
	         continue
		 }
        
        if index := strings.Index(line, " -d scsi "); index > -1 {
	        if  raidCount == 0 {
	        	if  numDev == 0 { // raid 장비가 아니고 두번째 디바이스 라는 뜻
		        	devNames[numDev] = diskName
	                numDev++
	        	}
	        	
		        devNames[numDev] = line[0:strings.Index(line, " -d scsi ")]
                numDev++
	        }
	        
	        diskName = line[0:index]
	        raidCount = 0
        } else {
	        if diskName != "" {
	        	str := "-d " + line[strings.Index(line, " -d ")+4:strings.Index(line, " # ")] + " " + diskName
	        	
	        	//fmt.Println(str)
	        	
		        devNames[numDev] = str
                numDev++
                raidCount++
	        }
        }
	}
	
	if diskName != "" && numDev == 0 {
		fmt.Println(diskName)
	}
	
	//fmt.Println(devNames)
	fmt.Println(numDev)
	
	for _, val := range devNames {
		fmt.Println(val)
	}
	
	fmt.Println("끝")
	
	//var str = "-d megaraid,0 /dev/sda"
	var str = "/dev/sda"
	
	fmt.Println(len(strings.Split(str, " ")))
	fmt.Println(strings.Split(str, " "))
	
	for _, val := range strings.Split(str, " ") {
		fmt.Println("val : " + val)
	}
	
	var tt = make([]string, 5)
	
	tt[0] = "-i"
	tt[1] = "/dev/sda"
	tt[2] = "/dev/sdb"
	
	arg(tt[0:len(tt)]...)
	
	/*
	var commands = []string{}
	
	fmt.Println(len(commands))
	
	commands[0] = "dsfsdf"
	
	fmt.Println(len(commands))
	*/
	
	/*
	for _, line := range lines {
		index := strings.Index(line, " -d scsi ")
		
		if strings.Contains(line, " -d scsi ") {
			fmt.Println(index)
			fmt.Println(line)
			fmt.Println(line[0:index])
		} else {
			index = strings.Index(line, " # ")
			fmt.Println(index)
			fmt.Println(line)
			fmt.Println(line[strings.Index(line, " -d ")+4:strings.Index(line, " # ")])
		}
		
		fmt.Println("")
		
		//fmt.Println(line)
	}

*/