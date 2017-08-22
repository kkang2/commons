package print

import (
	"fmt"
)

func PrintfExam() {
	var num1 int = 10
	var num2 float32 = 3.2
	var num3 complex64 = 2.5 + 8.1i
	var s string = "Hello, world!"
	var b bool = true
	var a []int = []int{1, 2, 3}
	var m map[string]int = map[string]int{"Hello": 1}
	var p *int = new(int)
	type Data struct{ a, b int }
	var data Data = Data{1, 2}
	var i interface{} = 1

	fmt.Printf("정수: %d\n", num1)     // 정수: 10
	fmt.Printf("실수: %f\n", num2)     // 실수: 3.2
	fmt.Printf("복소수: %f\n", num3)   // 복소수: (2.500000+8.100000i)
	fmt.Printf("문자열: %s\n", s)      // 문자열: Hello, world!
	fmt.Printf("불: %t\n", b)          // 불: true
	fmt.Printf("슬라이스: %v\n", a)    // 슬라이스: [1 2 3]
	fmt.Printf("맵: %v\n", m)          // 맵: map[Hello:1]
	fmt.Printf("포인터: %p\n", p)      // 포인터: 0xc0820062d0 (메모리 주소)
	fmt.Printf("구조체: %v\n", data)   // 구조체: {1 2}
	fmt.Printf("인터페이스: %v\n", i)  // 인터페이스: 1

	fmt.Printf("%d %f %s\n", num1, num2, s) // 10 3.200000 Hello, world!
}

func PrintlnExam() {
	var num1 int = 10
	var num2 float32 = 3.2
	var num3 complex64 = 2.5 + 8.1i
	var s string = "Hello, world!"
	var b bool = true
	var a []int = []int{1, 2, 3}
	var m map[string]int = map[string]int{"Hello": 1}
	var p *int = new(int)
	type Data struct{ a, b int }
	var data Data = Data{1, 2}
	var i interface{} = 1

	fmt.Println(num1) // 10: 정수 출력
	fmt.Println(num2) // 3.2: 실수 출력
	fmt.Println(num3) // (2.5+8.1i): 복소수 출력
	fmt.Println(s)    // Hello, world!: 문자열 출력
	fmt.Println(b)    // true: 불 출력
	fmt.Println(a)    // [1 2 3]: 슬라이스 출력
	fmt.Println(m)    // map[Hello:1]: 맵 출력
	fmt.Println(p)    // 0xc0820062d0: 포인터(메모리 주소) 출력
	fmt.Println(data) // {1 2}: 구조체 출력
	fmt.Println(i)    // 1: 인터페이스 출력

	fmt.Println(num1, num2, num3, s, b) // 10 3.2 (2.5+8.1i) Hello, world! true
	fmt.Println(p, a, m)                // 0xc0820062d0 [1 2 3] map[Hello:1]
	fmt.Println(data, i)                // {1 2} 1
}
