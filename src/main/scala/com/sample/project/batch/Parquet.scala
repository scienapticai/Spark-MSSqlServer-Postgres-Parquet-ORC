package com.sample.project.batch

import org.apache.spark.sql.SparkSession

object Parquet {

  def main(args: Array[String]) = {
    val spark = SparkSession.builder().master("local").getOrCreate()

    //reading lzo files
    val readPath = "/home/meghal/ether_new/datasources/userdata1.parquet.lzo"
    val writePath = "/home/meghal/ether_new/datasources/userdata1.lzo"
    //2.3 : Available codecs are uncompressed, gzip, lzo, snappy, none.
    //2.4 : Available codecs are brotli, uncompressed, lz4, gzip, lzo, snappy, none, zstd
    //https://stackoverflow.com/questions/23441142/class-com-hadoop-compression-lzo-lzocodec-not-found-for-spark-on-cdh-5

    val compression = "lzo"

    val df = spark.read
      .option("compression", compression)
    //  .option("mergeSchema", "false")
      .parquet(readPath)

    df.repartition(5)
      .write
      .format("parquet")
      .mode("overwrite")
      .option("compression", compression)
      .save(writePath)

  }
}
