package com.session.analyze.utils

import java.io.FileInputStream
import java.util.Properties

/**
  * Created by piguanghua on 2018/1/2.
  */
object PropertiesUtils {
	val properties = new Properties()
	var path = Thread.currentThread().getContextClassLoader.getResource("server.properties").getPath
	path = java.net.URLDecoder.decode(path, "utf-8")
	properties.load(new FileInputStream(path))




	def getPropertiesValueToString(key:String,default:String): String ={
		if(properties.get(key) == null){
			default
		}else
			properties.get(key).toString
	}

	def getPropertiesValueToBoolean(key:String,default:Boolean): Boolean ={
		if(properties.get(key) == null){
			default
		}else{
			val result = properties.get(key).toString
			result match  {
				case "true"=> true
				case "false" => false
			}
		}
	}

	def main(args : Array[String]): Unit = {
		val context = "aa"
		context match{
			case "aa" => println("aa")
			case "bb" => println("bb")
			case _ => println("cc")
		}
	}

}
