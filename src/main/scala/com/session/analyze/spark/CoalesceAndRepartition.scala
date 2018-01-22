package com.session.analyze.spark

/**
  * Created by piguanghua on 2018/1/22.
  *
  *  coalesce 重定义partition
  *  repartition 也是重定义partition但是需要shuffle
  */
object CoalesceAndRepartition {
	case class Employee(name: String, age: Long, depId: Long, gender: String, salary: Long)

	def main(args: Array[String]): Unit = {
		val spark = SparkUtils.getLocalSparkSession()
		import spark.implicits._
		val employee = spark.read.json("D:\\Data\\employee.json")
		val employeeDS = employee.as[Employee]
		println(employeeDS.rdd.partitions.size)
		println("coalesce:" + employee.coalesce(7).rdd.partitions.size)
		println("repartition:" + employee.repartition(5).rdd.partitions.size)
		println("coalesce2:" + employee.repartition(5).coalesce(2).rdd.partitions.size)
	}
}
