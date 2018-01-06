package eu.juusujanar.scala

import org.apache.spark.sql.SparkSession

object CreditCards {

  def main(args: Array[String]): Unit = {

    val sqlContext = SparkSession.builder().appName("Credit Cards").master("local").getOrCreate()

    val data = sqlContext.read
      .format("com.crealytics.spark.excel")
      .option("useHeader", "true")
      .option("treatEmptyValuesAsNulls", "true")
      .option("inferSchema", "true")
      .option("addColorColumns", "False")
      .load("src/main/resources/CreditCardDetails.xls")

    data.printSchema()

    // Split into test and training
    val (training, test) = data.randomSplit(Array[Double](0.6, 0.2, 0.2)) match {
      case Array(`training`, `test`) => (training, test)
    }


  }

}