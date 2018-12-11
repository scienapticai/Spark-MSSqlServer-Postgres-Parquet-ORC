name := "Spark-MSSqlServer-Postgres-Parquet-ORC"

version := "0.1"

scalaVersion := "2.11.12"

val sparkVersion = "2.4.0"

resolvers += Resolver.mavenLocal
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"


libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-hive" % sparkVersion,
  "org.apache.spark" %% "spark-mllib" % sparkVersion,

  "com.microsoft.sqlserver" % "mssql-jdbc" % "6.1.0.jre8",

  "org.postgresql" % "postgresql" % "42.2.5"
)
