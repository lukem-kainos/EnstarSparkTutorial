name := "EnstarSparkTutorial"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.0.1",
  "org.apache.spark" %% "spark-sql" % "2.0.1",
  "org.apache.spark" %% "spark-mllib" % "2.0.1",
  "mysql" % "mysql-connector-java" % "5.1.40",
  "com.databricks" %% "spark-avro" % "3.0.1"
)