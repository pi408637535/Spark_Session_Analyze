package com.session.analyze.spark

import org.apache.spark.sql.SparkSession

/**
  * Created by piguanghua on 2018/1/22.
  */
object JoinWithStudy {
	case class Employee(name: String, age: Long, depId: Long, gender: String, salary: Long)
	case class Department(id: Long, name: String)


	def main(args: Array[String]): Unit = {
		val spark:SparkSession = SparkUtils.getLocalSparkSession()
		import spark.implicits._
		val employee = spark.read.json("D:\\Data\\employee.json")
		val department = spark.read.json("D:\\Data\\department.json")

		val employeeDF = employee.as[Employee]
		val departmentDF = department.as[Department]

	//	employeeDF.join(departmentDF, $"depId" === $"id").show()
	//	employeeDF.joinWith(departmentDF, $"depId" === $"id").show()

	//	employee.sort($"salary".desc).show()
		employeeDF.sort($"salary".desc).show()
	}
}
