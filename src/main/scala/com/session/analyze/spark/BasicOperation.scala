package com.session.analyze.spark

import org.apache.hadoop.hdfs.server.common.Storage
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel

/**
  * Created by piguanghua on 2018/1/22.
  * 持久化：cache、persist
  * 创建临时视图：createTempView、createOrReplaceTempView
  * 获取执行计划：explain
  * 查看schema：printSchema
  * 写数据到外部存储：write
  * dataset与dataframe互相转换：as、toDF
  */
object BasicOperation {
	case class Employee(name: String, age: Long, depId: Long, gender: String, salary: Long)

	def main(args: Array[String]): Unit = {
		val spark:SparkSession = SparkUtils.getLocalSparkSession()
		val employee = spark.read.json("D:\\Data\\employee.json")
		val department = spark.read.json("D:\\Data\\department.json")
		employee.cache()
	//	employee.persist(StorageLevel.MEMORY_AND_DISK).write.save()
		// 创建临时视图，被创建的视图可以利用sql来执行
	/*	employee.createOrReplaceTempView("employee")
		spark.sql("select * from employee where age > 30").show()*/

		//whole-stage code generation
		/*employee.createOrReplaceTempView("employee")
		spark.sql("select * from employee where age > 30").explain()*/

		//printSchema
		//employee.printSchema()

		//val employeeWithAgeGreaterThen30DF = spark.sql("select * from employee where age > 30")
		//    employeeWithAgeGreaterThen30DF.write.json("C:\\Users\\Administrator\\Desktop\\employeeWithAgeGreaterThen30DF.json")

		//DF -> DS
		import spark.implicits._
		val employeeDS = employee.as[Employee]
/*
		employeeDS.show()
		employeeDS.printSchema()
*/

		//DS ->DF

		val employeeDF = employeeDS.toDF()
		employeeDF.printSchema()
	}
}
