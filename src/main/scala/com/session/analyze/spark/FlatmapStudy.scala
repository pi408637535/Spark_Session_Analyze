package com.session.analyze.spark

import org.apache.spark.sql.SparkSession

/**
  * Created by piguanghua on 2018/1/22.
  */
object FlatmapStudy {
	case class Employee(name: String, age: Long, depId: Long, gender: String, salary: Long)

	def main(args: Array[String]): Unit = {
		val spark:SparkSession = SparkUtils.getLocalSparkSession()
		val employee = spark.read.json("D:\\Data\\employee.json")
		import spark.implicits._
		employee.flatMap(ele => Seq(1,2)).show()
	}
}
