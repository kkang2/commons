package mariadb

import (
	"database/sql"
	_ "github.com/go-sql-driver/mysql"
	"log"
	"fmt"
)

var afmediaConStr = "afmedia:afmedia123@tcp(211.214.168.102:38306)/afmedia"
var unknownConStr = "alarmuser:1234@tcp(211.214.168.102:13306)/alarm_db"
var localConStr = "mallakkang:mallakkang@tcp(192.168.137.129:3306)/test_db"

func SelectOne() {
	db, err := sql.Open("mysql", unknownConStr)
	
	if err != nil {
		log.Fatal(err)
	}
	
	defer db.Close()
	
	var alarmCode string
	
	err = db.QueryRow("SELECT ALARM_CODE FROM TROI_EVENT_SERVER_ALARM").Scan(&alarmCode)
	
    if err != nil {
        log.Fatal(err)
    }
    
    fmt.Println(alarmCode)
}

func SelectList() {
	db, err := sql.Open("mysql", unknownConStr)
	
	if err != nil {
		log.Fatal(err)
	}
	
	defer db.Close()
	
	var alarmSeq, status, alarmCode string
	
	rows, err := db.Query("SELECT ALARM_SEQ, STATUS, ALARM_CODE FROM TROI_EVENT_SERVER_ALARM where ALARM_SEQ < ?", 10)
	
	if err != nil {
        log.Fatal(err)
    }
	
	defer rows.Close() //반드시 닫는다 (지연하여 닫기)
	
    for rows.Next() {
        err := rows.Scan(&alarmSeq, &status, &alarmCode)
        
        if err != nil {
            log.Fatal(err)
        }
        
        fmt.Println(alarmSeq, alarmCode, status)
    }
}

func Insert() {
	db, err := sql.Open("mysql", localConStr)
	
	if err != nil {
		log.Fatal(err)
	}
	
	defer db.Close()
	
	// INSERT 문 실행
    result, err := db.Exec("INSERT INTO alarm_test (ALARM_SEQ, ALARM_CODE, STATUS) VALUES (?, ?, ?)", 1, "EVENT-001", "O")
    
    if err != nil {
        log.Fatal(err)
    }
 
    // sql.Result.RowsAffected() 체크
    n, err := result.RowsAffected()
    
    if n == 1 {
        fmt.Println("1 row inserted.")
    }
}

func PrepareInsert() {
	db, err := sql.Open("mysql", localConStr)
	
	if err != nil {
		log.Fatal(err)
	}
	
	defer db.Close()
	
	// Prepared Statement 생성
    stmt, err := db.Prepare("INSERT INTO alarm_test (ALARM_SEQ, ALARM_CODE, STATUS) VALUES (?, ?, ?)")
    checkError(err)
    
    defer stmt.Close()
    
    // Prepared Statement 실행
    _, err = stmt.Exec(2, "EVENT-002", "O") //Placeholder 파라미터 순서대로 전달
    checkError(err)
    
    _, err = stmt.Exec(3, "EVENT-003", "O")
    checkError(err)
    
    fmt.Println("쿼리실행 성공!!")
}

func TransactionInsert() {
	db, err := sql.Open("mysql", localConStr)
	
	if err != nil {
		log.Fatal(err)
	}
	
	defer db.Close()
	
	// 트랜잭션 시작
    tx, err := db.Begin()
    
    if err != nil {
        log.Fatal(err)
    }
    
    defer tx.Rollback() //중간에 에러시 롤백
 
    // INSERT 문 실행
    _, err = db.Exec("INSERT INTO alarm_test (ALARM_SEQ, ALARM_CODE, STATUS) VALUES (?, ?, ?)", 4, "EVENT-004", "O")
    if err != nil {
        log.Fatal(err)
    }
 
    _, err = db.Exec("INSERT INTO alarm_test (ALARM_SEQ, ALARM_CODE, STATUS) VALUES (?, ?, ?)", 6, "EVENT-006", "O")
    if err != nil {
        log.Fatal(err)
    }
 
    // 트랜잭션 커밋
    err = tx.Commit()
    if err != nil {
        log.Fatal(err)
    }
    
    fmt.Println("트랜잭션 커밋 성공!!")
}

func checkError(err error) {
    if err != nil {
        panic(err)
    }
}