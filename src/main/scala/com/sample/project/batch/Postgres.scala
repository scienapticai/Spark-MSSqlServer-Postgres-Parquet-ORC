package com.sample.project.batch

import java.util.Properties
import org.apache.spark.sql.SparkSession

object Postgres extends App {

  val spark = SparkSession.builder().master("local").getOrCreate()
  val url = "jdbc:postgresql://localhost:5432/"
  val inputTableName = "public.playground"
  val user = "postgres"

  val props = new Properties()
  props.put("user", user)
  props.put("password", "somepwd")
  props.put("driver", "org.postgresql.Driver")

  val df = spark.read.jdbc(url, inputTableName, props)

  df.write.jdbc(url, "output_sample", props)
}
