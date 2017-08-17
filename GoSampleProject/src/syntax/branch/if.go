package main

import (
	"fmt"
)

func main() {
	/*var b[] byte
	var err error
	
	b, err = ioutil.ReadFile("./hello.txt")
	
	if err == nil {
		fmt.Printf("%s", b)
	}
	
	if b, err := ioutil.ReadFile("./hello.txt"); err == nil {
		fmt.Printf("%s", b)
	}*/
	
	var num = 101
	
	if num == 10 {
		fmt.Println("num == 10")
	} else if num < 10 {
		fmt.Println("num < 10")
	} else {
		fmt.Println("etc")
	}
	
}
