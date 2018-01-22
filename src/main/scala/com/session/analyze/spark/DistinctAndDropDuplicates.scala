package com.session.analyze.spark

/**
  * Created by piguanghua on 2018/1/22.
  * distinct 每一条记录,完整内容去重
  * dropDuplicates 指定内容去重
  */
object DistinctAndDropDuplicates {
	def main(args: Array[String]): Unit = {
		val spark = SparkUtils.getLocalSparkSession()
		import spark.implicits._
		val employees = spark.read.json("D:\\Data\\employees.json")
		employees.distinct().show()
		println("----------------------------")
		employees.dropDuplicates("salary","name").show()
	}
}
