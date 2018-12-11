package com.sample.project.batch

import org.apache.spark.sql.{SaveMode, SparkSession}

object Orc extends App {
  val spark = SparkSession.builder().master("local").getOrCreate()

  val readPath = "/home/meghal/ether_new/datasources/orc1.orc"
  val writePath = "/home/meghal/ether_new/datasources/orc"
  //2.3 :  Available codecs are uncompressed, lzo, snappy, zlib, none
  //2.4 : Available codecs are uncompressed, lzo, snappy, zlib, none
  val compression = "gzip"

  val df =
    spark.read
      .format("orc")
      .load(readPath)

  df.write
    .format("orc")
    .mode(SaveMode.Overwrite)
    .option("compression", compression)
    .save(writePath)

}
