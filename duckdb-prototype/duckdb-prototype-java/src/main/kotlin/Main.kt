package com.ajcode404

import org.duckdb.DuckDBConnection
import java.sql.DriverManager

fun main() {
    val filepath = "src/main/resources/matches.csv"
    val conn = DriverManager.getConnection("jdbc:duckdb:") as DuckDBConnection
    val stmt = conn.createStatement()
    stmt.execute("create table matches as from '$filepath';")

    val rs = stmt.executeQuery("select * from matches limit 5;")
    while (rs.next()) {
        println(rs.getString(1))
        println(rs.getString(2))
    }
}