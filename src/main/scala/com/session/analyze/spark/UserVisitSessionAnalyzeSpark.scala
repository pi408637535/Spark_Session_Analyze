package com.session.analyze.spark

import com.session.analyze.config.ConfigManager
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

/**
  * Created by piguanghua on 2018/1/3.
  */
object UserVisitSessionAnalyzeSpark {
	def main(args: Array[String]) {

		val spark = SparkSession
		  .builder
		  .appName(s"${this.getClass.getSimpleName}")
		 .master("local[*]")
			  .config("spark.sql.warehouse.dir", "D:\\Data\\spark-warehouse")
		  .getOrCreate()
		val sc = spark.sparkContext //创建环境变量实例

		spark.stop()
	}

	def mockData(sc:SparkContext)={
		val local = ConfigManager.spark_local
		if(local){

		}
	}
}
