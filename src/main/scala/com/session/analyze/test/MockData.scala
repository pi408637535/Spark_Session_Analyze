package com.session.analyze.test

import org.apache.spark.SparkContext

import scala.util.Random
import java.util.UUID
/**
  * Created by piguanghua on 2018/1/3.
  */
object MockData {
	def mock(sc:SparkContext)={
		val searchKeywords = Array("火锅", "蛋糕", "重庆辣子鸡", "重庆小面",
			"呷哺呷哺", "新辣道鱼火锅", "国贸大厦", "太古商场", "日本料理", "温泉")
		val actions = Array("search", "click", "order", "pay")
		val random = new Random()
		for( i <- 1 to 100){
			val userId = random.nextInt(100)
			for(j <- 1 to 10){
				val sessionId = UUID.randomUUID.toString.replace("-", "")

				val baseActionTime = ""
				var clickCategoryId:Long = 0

				for(k <- 1 to random.nextInt(100)){
					val pageId = random.nextInt(10)
					var actionTime = ""
					var searchKeyword = ""
					var clickProductId:Long = 0
					var orderCategoryIds = ""
					var orderProductIds = ""
					var payCategoryIds = ""
					var payProductIds = ""

					val action = actions(random.nextInt(4))
					action match {
						case "search"=>
							searchKeyword = searchKeywords(random.nextInt(10))
						case "click"=>{
							clickCategoryId = random.nextInt(100).toLong
							clickProductId =  random.nextInt(100).toLong
						}
						case "order"=>{
							orderCategoryIds = random.nextInt(100).toString
							orderProductIds = random.nextInt(100).toString
						}
						case "pay"=>{
							payCategoryIds = random.nextInt(100).toString
							payProductIds = random.nextInt(100).toString
						}

					}

				}

			}
		}

	}
}
