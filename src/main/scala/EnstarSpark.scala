import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


object EnstarSpark {
  def main(args: Array[String]) {
    val conf = new SparkConf()
      .setAppName("Simple Application")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val sparkSession = SparkSession.builder.config(conf).getOrCreate()

    // look at the readme and count how many lines have an "a" and how many a "b"
    val logFile = "README.md" // Should be some file on your system
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))


    //this is the database bit that we are interested in //TODO remove this
    val employees = sparkSession.read.format("jdbc")
      .option("url", "jdbc:mysql://localhost:3306/employees?autoReconnect=true&useSSL=false")
      .option("user", "root")
      .option("password", "")
      .option("dbtable", "employees.employees")
      .load()

    val dept_emp = sparkSession.read.format("jdbc")
      .option("url", "jdbc:mysql://localhost:3306/employees?autoReconnect=true&useSSL=false")
      .option("user", "root")
      .option("password", "")
      .option("dbtable", "employees.dept_emp")
      .load()

    employees.show()
    dept_emp.show()

    val joinedTables = employees.join(dept_emp, Seq("emp_no"))
    joinedTables
      .filter(row => row.getAs("gender") == "M")
      .show()

    val tableWithoutDates = joinedTables.drop("birth_date", "hire_date", "from_date", "to_date")

    tableWithoutDates.write.format("com.databricks.spark.avro").save("tmp/output")
    sc.stop()
  }
}
