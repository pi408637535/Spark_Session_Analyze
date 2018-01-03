package com.session.analyze.config

import java.io.FileInputStream
import java.util.Properties

import com.session.analyze.utils.PropertiesUtils

/**
  * Created by piguanghua on 2018/1/2.
  */
object ConfigManager {


	val spark_local = PropertiesUtils.getPropertiesValueToBoolean("spark.local", true)


	def main(args: Array[String]) = {
		println(spark_local)
	}
}