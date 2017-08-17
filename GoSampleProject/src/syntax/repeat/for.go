package main

import (
	"fmt"
)

func main() {
	/*
	for i :=0; i < 5; i++ {
		fmt.Println(i)
	}
	
	//while 문 처럼 사용하기
	j := 0
	
	for j < 5 {
		fmt.Println(j)
		j = j + 1 // i++
	}*/
	
	/*무한루프
	for {
		fmt.Println("Hello, world!")
	}*/
	
	/*i := 0
	
	for {
		if i > 4 { // i가 4가 되는 순간
			break  // 반복문이 중단됩니다.
		}
	
		fmt.Println(i)
		i = i + 1 // 변화식에서 조건을 변경합니다.
	}*/
	
	//레이블을 사용해서 이중반복문 한번에 빠져 나오기
	/*Loop: // Loop 레이블을 지정
		for i := 0; i < 3; i++ {           // 반복문 1
			for j := 0; j < 3; j++ {   // 반복문 2
				if j == 2 {        // j가 2일 때
					break Loop // 중첩된 반복문을 빠져나옴
				}
	
				fmt.Println(i, j)
			}
		}
	
		fmt.Println("Hello, world!")*/
	
	//변수 여러 개 사용하기
	for i, j := 0, 0; i < 10; i, j = i+1, j+2 {
		fmt.Println(i, j)
	}
}