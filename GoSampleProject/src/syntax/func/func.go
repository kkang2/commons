package main

import (
	"fmt"
)

func main() {
	func() { // 함수에 이름이 없음
		fmt.Println("Hello, world!")
	}()

	func(s string) {   // 익명 함수를 정의한 뒤
		fmt.Println(s)
	}("Hello, world!") // 바로 호출

	r := func(a int, b int) int { // 익명 함수를 정의한 뒤
		return a + b
	}(1, 2)                       // 바로 호출하여 리턴값을 변수 r에 저장

	fmt.Println(r) // 3
	
	/*
	f := []func(int, int) int{sum, diff} // 함수를 저장할 수 있는 슬라이스를 생성한 뒤 함수로 초기화

	fmt.Println(f[0](1, 2)) // 3: 배열의 첫 번째 요소로 함수 호출
	fmt.Println(f[1](1, 2)) // -1: 배열의 두 번째 요소로 함수 호출
	*/
	
	/*f := map[string]func(int, int) int{ // 함수를 저장할 수 있는 맵을 생성한 뒤 함수로 초기화
		"sum":  sum,
		"diff": diff,
	}

	fmt.Println(f["sum"](1, 2))  // 3: 맵에 sum 키를 지정하여 함수 호출
	fmt.Println(f["diff"](1, 2)) // -1: 맵에 diff 키를 지정하여 함수 호출
	*/
	/*
	// 변수에 함수 대입
	var hello func(a int, b int) int = sum // 함수를 저장하는 변수를 선언하고 함수 대입
	world := sum                           // 변수 선언과 동시에 함수를 바로 대입

	fmt.Println(hello(1, 2)) // 3: hello 변수에 저장된 sum 함수 호출
	fmt.Println(world(1, 2)) // 3: world 변수에 저장된 sum 함수 호출
	
	fmt.Println(factorial(5)) // 120
	*/
	/*
	n := []int{1, 2, 3, 4, 5}
	r := sum2(n...) // ...를 사용하여 가변인자에
                        // 슬라이스를 바로 넘겨줌

	fmt.Println(r) // 15
	
	sum, diff := SumAndDiff(6, 2) // 변수 두 개에 리턴값 두 개를 대입
	fmt.Println(sum, diff)        // 8 4: 합과 차
	
	r := sum(1, 2)
	
	fmt.Println(r)
	fmt.Println(sum1(3, 5))
	
	hello()
	*/
}

func factorial(n uint64) uint64 {
	if n == 1 {
		return 1
	}

	return n * factorial(n-1)
}

func hello() {
	fmt.Println("Hello world!")
}

func sum(a int, b int) int {
	return a + b
}

func diff(a int, b int) int {
	return a - b
}

func sum2(n ...int) int { // int형 가변인자를 받는 함수 정의
	total := 0
	for _, value := range n { // range로 가변인자의 모든 값을 꺼냄
		total += value   // 꺼낸 값을 모두 더함
	}

	return total
}

//                               ↓ 리턴 값 변수의 이름을 r로 지정
func sum1(a int, b int) (r int) {
	r = a + b // 리턴값 변수 r에 값 대입
	return    // 리턴값 변수를 사용할 때는 return 뒤에 변수를 지정하지 않음
}

func SumAndDiff(a int, b int) (int, int) { // int형 리턴값이 두 개인 함수 정의
	return a + b, a - b // 리턴할 값 또는 변수를 차례대로 나열. 합과 차를 동시에 리턴
}

func SumAndDiff1(a int, b int) (sum int, diff int) { // 리턴값을 각각 sum, diff로 이름을 정함
	sum = a + b  // 리턴값 변수 sum에 합 대입
	diff = a - b // 리턴값 변수 diff에 차 대입
	return
}