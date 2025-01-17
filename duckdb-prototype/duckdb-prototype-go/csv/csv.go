package csv

import (
	"database/sql"
	"fmt"
)

func LoadCsv(dbName string, path string) {
	// Load CSV file from path
	db, err := sql.Open("duckdb", path)
	if err != nil {
		panic(err)
	}
	defer db.Close()
	query := fmt.Sprintf("create table %s as from %s;", dbName, path)
	_, err = db.Exec(query)
	if err != nil {
		panic(err)
	}
	query = fmt.Sprintf("select format('{:,}', count(*)) as %s from %s;", dbName, path)
	rows, err := db.Query(query)
	if err != nil {
		panic(err)
	}
	defer rows.Close()
	for rows.Next() {
		var count string
		err = rows.Scan(&count)
		if err != nil {
			panic(err)
		}
		fmt.Printf("Loaded %s records from %s\n", count, path)
	}
}
