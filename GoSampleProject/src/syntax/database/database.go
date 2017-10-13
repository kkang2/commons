package main

import (
	"syntax/database/mariadb"
)

func main() {
	//mariadb.SelectOne()
	//mariadb.SelectList()
	//mariadb.Insert()
	//mariadb.PrepareInsert()
	mariadb.TransactionInsert()
}