package com.session.analyze.spark

import org.apache.spark.sql.SparkSession

/**
  * Created by piguanghua on 2018/1/3.
  *
  * 需求：
  * 		1、只统计年龄在20岁以上的员工
  * 		2、根据部门名称和员工性别为粒度来进行统计
  * 		3、统计出每个部门分性别的平均薪资和年龄
  *
  */
object DepartmentAvgSalaryAndAgeStat {
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

		employee.filter("age > 20")
		  // 注意：untyped join，两个表的字段的连接条件，需要使用三个等号
		  .join(department, $"depId" === $"id")
		  // 根据部门名称和员工性别进行分组
		  .groupBy(department("name"), employee("gender"))
		// 最后执行聚合函数
	      	.agg(avg(employee("salary")),avg(employee("age"))).show()



		spark.stop()
	}
}
