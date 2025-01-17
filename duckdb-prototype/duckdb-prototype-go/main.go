package main

import (
	"database/sql"
	"errors"
	"log"

	_ "github.com/marcboeker/go-duckdb" // Import the driver
)

func main() {
	db, err := sql.Open("duckdb", "")
	if err != nil {
		panic(err)
	}

	defer db.Close()

	_, err = db.Exec("CREATE TABLE people (id INTEGER, name VARCHAR)")
	if err != nil {
		panic(err)
	}
	_, err = db.Exec("INSERT INTO people VALUES (1, 'John Doe')")
	if err != nil {
		panic(err)
	}

	var (
		id   int
		name string
	)
	row := db.QueryRow(`SELECT id, name FROM people`)
	err = row.Scan(&id, &name)
	if errors.Is(err, sql.ErrNoRows) {
		log.Println("No rows")
	} else if err != nil {
		panic(err)
	}
	log.Printf("id: %d, name: %s\n", id, name)
}
