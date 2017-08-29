package main

import (
	"time"
	"fmt"
	"strings"
)

func main() {
	
	metricMap := make(map[string]string)
	
	var str string = "/dev/sda"
	
	for _, val := range strings.Split(str[1:], "/") {
		fmt.Println(val)
	}
	
	fmt.Println(time.Now())
	
	//var strs = []string{"dev", "sda"}
	
	mkStr(strings.Split(str[1:], "/")...)
}

func mkStr(strs ...string) {
	fmt.Println(len(strs))
	
	var str = "/" + strings.Join(strs, "/")

	fmt.Println(str)
	
	/*
	for _, str := range strs {
		fmt.Println(str)
	}
	*/
}