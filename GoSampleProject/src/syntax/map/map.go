package main

import (
	"fmt"
)

func main() {
	/*
	var a1 map[string]int // 키는 string, 값은 int인 맵 선언
	var a map[string]int = make(map[string]int) // make 함수로 키는 string 값은 int인 맵에 공간 할당
	var b = make(map[string]int)                // 맵을 선언할 때 map 키워드와 자료형 생략
	c := make(map[string]int)                   // 맵을 선언할 때 var, map 키워드와 자료형 생략
	
	
	
	a := map[string]int{"Hello": 10, "world": 20}

	b := map[string]int{
		"Hello": 10,
		"world": 20, // 여러 줄로 나열할 때는 마지막 요소에 콤마를 붙임
	}
	
	fmt.Println(a["Hello"]) // 10
	fmt.Println(b["world"]) // 10
	fmt.Println(a) // 10
	*/
	
	solarSystem := make(map[string]float32) // 키는 string, 값은 float32인 맵 생성 및 공간 할당

	solarSystem["Mercury"] = 87.969 // 맵[키] = 값
	solarSystem["Venus"] = 224.70069
	/*
	fmt.Println(solarSystem["Mercury"]) // 87.969
	fmt.Println(solarSystem["none"])
	
	value, ok := solarSystem["Mercury"] // 맵에 키가 있는지 검사할 때는 리턴값을 두 개 활용
	fmt.Println(value, ok)            // 0 false: 맵에 키가 없으면 두 번째 리턴값으로 false가 리턴됨
	
	if value, ok := solarSystem["Saturn"]; ok {
		fmt.Println(value) // 10756.1995
	}
	
	for key, value := range solarSystem { // 반복문이 실행될 때마다 키와 값이 자동으로 변수에 들어감
		fmt.Println(key, value)
	}
	
	for _, value := range solarSystem { // 키 변수를 사용하고 싶지 않다면 _ 사용
		fmt.Println(value)
	}
	*/
	
	a := map[string]int{"Hello": 10, "world": 20}

	delete(a, "world") // 맵 a에서 world 키 삭제
	
	fmt.Println(a) // map[Hello:10]
	
	terrestrialPlanet := map[string]map[string]float32{
		"Mercury": map[string]float32{
			"meanRadius":    2439.7,
			"mass":          3.3022E+23,
			"orbitalPeriod": 87.969,
		},
		"Venus": map[string]float32{
			"meanRadius":    6051.8,
			"mass":          4.8676E+24,
			"orbitalPeriod": 224.70069,
		},
		"Earth": map[string]float32{
			"meanRadius":    6371.0,
			"mass":          5.97219E+24,
			"orbitalPeriod": 365.25641,
		},
		"Mars": map[string]float32{
			"meanRadius":    3389.5,
			"mass":          6.4185E+23,
			"orbitalPeriod": 686.9600,
		},
	}

	fmt.Println(terrestrialPlanet["Mars"]["mass"]) // 6.4185E+23
}