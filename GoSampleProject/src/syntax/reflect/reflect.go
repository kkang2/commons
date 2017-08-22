package main

import (
	"fmt"
	"reflect"
)

type Person struct {
	name string `tag1:"이름" tag2:"Name"` // 구조체에 태그 설정
	age  int    `tag1:"나이" tag2:"Age"`  // 구조체에 태그 설정
}

func main() {
	dynamicFunc()
	//pointerAndInterfaceReflect()
	//structTagReflect()
	//floatReflect()
}

func h(args []reflect.Value) []reflect.Value { // 매개변수와 리턴값은 반드시 
                                               // []reflect.Value를 사용
	fmt.Println("Hello, world!")
	return nil
}

func dynamicFunc() {
	var hello func() // 함수를 담을 변수 선언

	fn := reflect.ValueOf(&hello).Elem() // hello의 주소를 넘긴 뒤 Elem으로 값 정보를 가져옴

	v := reflect.MakeFunc(fn.Type(), h) // h의 함수 정보를 생성

	fn.Set(v) // hello의 값 정보인 fn에 h의 함수 정보 v를 설정하여 함수를 연결

	hello()
}

func pointerAndInterfaceReflect() {
	var a *int = new(int)
	*a = 1

	fmt.Println(reflect.TypeOf(a))               // *int
	fmt.Println(reflect.ValueOf(a))              // <*int Value>
	//fmt.Println(reflect.ValueOf(a).Int())        // 런타임 에러
	fmt.Println(reflect.ValueOf(a).Elem())       // <int Value>
	fmt.Println(reflect.ValueOf(a).Elem().Int()) // 1

	var b interface{}
	b = 1

	fmt.Println(reflect.TypeOf(b))         // int
	fmt.Println(reflect.ValueOf(b))        // <int Value>
	fmt.Println(reflect.ValueOf(b).Int())  // 1
	fmt.Println(reflect.ValueOf(b).Elem()) // 런타임 에러
}

func structTagReflect() {
	p := Person{}

	name, ok := reflect.TypeOf(p).FieldByName("name")
	fmt.Println(ok, name.Tag.Get("tag1"), name.Tag.Get("tag2")) // true 이름 Name

	age, ok := reflect.TypeOf(p).FieldByName("age")
	fmt.Println(ok, age.Tag.Get("tag1"), age.Tag.Get("tag2")) // true 나이 Age
}

func floatReflect() {
	var f float64 = 1.3
	t := reflect.TypeOf(f)  // f의 타입 정보를 t에 저장
	v := reflect.ValueOf(f) // f의 값 정보를 v에 저장

	fmt.Println(t.Name())                    // float64: 자료형 이름 출력
	fmt.Println(t.Size())                    // 8: 자료형 크기 출력
	fmt.Println(t.Kind() == reflect.Float64) // true: 자료형 종류를 알아내어 
                                                 // reflect.Float64와 비교
	fmt.Println(t.Kind() == reflect.Int64)   // false: 자료형 종류를 알아내어 reflect.Int64와 비교

	fmt.Println(v.Type())                    // float64: 값이 담긴 변수의 자료형 이름 출력
	fmt.Println(v.Kind() == reflect.Float64) // true: 값이 담긴 변수의 자료형 종류를 
                                                 // 알아내어 reflect.Float64와 비교
	fmt.Println(v.Kind() == reflect.Int64)   // false: 값이 담긴 변수의 자료형 종류를 
                                                 // 알아내어 reflect.Int64와 비교
	fmt.Println(v.Float())                   // 1.3: 값을 실수형으로 출력
}