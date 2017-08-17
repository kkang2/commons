package main

import (
	"fmt"
)

func main() {
	/*
	var a []int = make([]int, 5) // make 함수로 int형에 길이가 5인 슬라이스에 공간 할당
	var b = make([]int, 5)       // 슬라이스를 선언할 때 자료형과 [] 생략
	c := make([]int, 5)          // 슬라이스를 선언할 때 var 키워드, 자료형과 [] 생략
	
	var s = make([]int, 5, 10) // 길이가 5이고 용량이 10인 슬라이스 생성
	
	
	a := make([]int, 5, 10)

	fmt.Println(len(a)) // 길이는 5
	fmt.Println(cap(a)) // 용량은 10
	
	
	a := []int{1, 2, 3}

	a = append(a, 4, 5, 6)
	
	fmt.Println(a) // [1 2 3 4 5 6] 
	
	a := []int{1, 2, 3}
	b := []int{4, 5, 6}
	
	a = append(a, b...) // 슬라이스 a에 슬라이스 b를 붙일 때는 b...을 씀
	
	fmt.Println(a) // [1 2 3 4 5 6]
	*/
	a := []int{1, 2, 3}
	b := make([]int, 3)
	
	copy(b, a)     // 슬라이스를 복사하였으므로
	b[0] = 9       // b[0]만 바뀌고, a[0]은 바뀌지 않음
	
	fmt.Println(a) // [1 2 3]
	fmt.Println(b) // [9 2 3]
}