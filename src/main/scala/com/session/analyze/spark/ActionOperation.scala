package com.session.analyze.spark

import org.apache.spark.sql.SparkSession

/**
  * Created by piguanghua on 2018/1/22.
  */
object ActionOperation {
	def main(args: Array[String]) {

		val spark = SparkSession
		  .builder
		  .appName(s"${this.getClass.getSimpleName}")
		  .master("local[*]")
		  .config("spark.sql.warehouse.dir", "D:\\Data\\spark-warehouse")
		  .getOrCreate()
		val sc = spark.sparkContext //创建环境变量实例
		// 导入spark的隐式转换
		import spark.implicits._
		// 导入spark sql的functions
		import org.apache.spark.sql.functions._

		val employee = spark.read.json("D:\\Data\\employee.json")
		val department = spark.read.json("D:\\Data\\department.json")

		println(employee.collect().size)
		println(employee.count())

	}
}
