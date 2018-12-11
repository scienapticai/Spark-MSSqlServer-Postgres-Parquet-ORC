package com.sample.project.batch

import java.util.Properties
import org.apache.spark.sql.SparkSession

object MSSqlServer extends App {

  val spark = SparkSession.builder().master("local").getOrCreate()

  val url = "jdbc:sqlserver://localhost:1433/TestDB"
  val inputTableName = "Inventory"

  val props = new Properties()
  props.put("user", "SA")
  props.put("password", "Somepwd123")
  props.put("driver", "com.microsoft.sqlserver.jdbc.SQLServerDriver")

  val df = spark.read.jdbc(url, inputTableName, props)

  df.write.jdbc(url, "output_sample", props)
}
