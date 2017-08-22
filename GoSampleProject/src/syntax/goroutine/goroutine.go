package main

import (
	"fmt"
	"runtime"
	"math/rand"
	"time"
)

func hello(n int) {
	r := rand.Intn(100)          // 랜덤한 숫자 생성
	time.Sleep(time.Duration(r)) // 랜덤한 시간 동안 대기
	fmt.Println(n)               // n 출력
}

func main() {
	runtime.GOMAXPROCS(runtime.NumCPU()) // CPU 개수를 구한 뒤 사용할 최대 CPU 개수 설정

	fmt.Println(runtime.GOMAXPROCS(0)) // 설정 값 출력

	s := "Hello, world!"

	for i := 0; i < 100; i++ {
		go func(n int) { // 익명 함수를 고루틴으로 실행
			fmt.Println(s, n)
		}(i)
	}

	/*
	for i := 0; i < 100; i++ { // 100번 반복하여
		go hello(i)        // 고루틴 100개 생성
	}
*/
	fmt.Scanln()
}