import groovy.sql.Sql
def sql = Sql.newInstance("jdbc:oracle:thin:@//localhost:1521/orcl", "asoni", "asoni", "oracle.jdbc.driver.OracleDriver")
sql.eachRow("select * from tabs"){
    println it.table_name }