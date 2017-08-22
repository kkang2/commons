package scan

import (
	"fmt"
)

func Scan() {
	var s1, s2 string
	n, _ := fmt.Scan(&s1, &s2) // fmt.Scan 함수의 두 번째 리턴값은 생략
	fmt.Println("입력 개수:", n)
	fmt.Println(s1, s2)
}

func Scanln() {
	var s1, s2 string
	n, _ := fmt.Scanln(&s1, &s2)
	fmt.Println("입력 개수:", n)
	fmt.Println(s1, s2)
}