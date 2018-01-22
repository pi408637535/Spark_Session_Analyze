package com.session.analyze.spark

import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

/**
  * Created by piguanghua on 2018/1/22.
  */
object SparkUtils {
	def getLocalSparkSession(): SparkSession ={
		val spark = SparkSession
		  .builder
		  .appName(s"${this.getClass.getSimpleName}")
		  .master("local[*]")
		  .config("spark.sql.warehouse.dir", "D:\\Data\\spark-warehouse")
		  .getOrCreate()
		val sc = spark.sparkContext //创建环境变量实例
		spark
	}
}
