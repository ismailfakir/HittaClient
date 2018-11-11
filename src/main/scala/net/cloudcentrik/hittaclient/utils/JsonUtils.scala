package net.cloudcentrik.hittaclient.utils

import net.cloudcentrik.hittaclient.model.{Coordinate, Restaurant, StreetView}
import net.cloudcentrik.hittaclient.service.HittaClient
import org.json4s.DefaultFormats
import org.json4s.JsonAST.JObject
import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.json4s.jackson.Serialization
import org.json4s.jackson.Serialization.{read, write}

import scala.collection.script.End
import scala.util.parsing.json.Parser


object JsonUtils{

  implicit val formats = DefaultFormats

  //testReadWrite
  parseCoOrdinate(HittaClient.findAddress("Vårvädersgatan 17 Göteborg"))

  def testReadWrite={

    val point=write(Coordinate(6404318.871309763,1271121.3257834697,"EPSG:3021"))

    println(point)

    val coordinate=read[Coordinate](point)
    println(coordinate.system)
  }

  def parseCoOrdinate(jsonAddress:JValue)={
    (jsonAddress \ "result" \ "location" \ "address" \ "streetview" \ "coordinate").extract[Coordinate]
  }

  def findRestaurantNameList(jsonRestaurant:JValue)={
    implicit val formats = DefaultFormats



    val restaurant=(jsonRestaurant \ "result" \ "companies" \ "company")

    val names= for { JString(name) <- restaurant \\ "displayName" } yield name

    names.asInstanceOf[List[String]]
  }

  def findCoOrdinate(address:JValue): String ={
    val north=(address \ "result" \ "location" \ "address" \ "streetview" \ "coordinate" \ "north").values.toString.take(9)
    val east=(address \ "result" \ "location"  \ "address" \ "streetview" \ "coordinate" \ "east").values.toString.take(9)
    s"$north:$east~RT90"
  }

  def parseRestaurantList(json:JValue)={

    val restaurants=(json \ "result" \ "companies" \ "company").asInstanceOf[JArray].arr

    val restaurantList: List[Restaurant]=for {
      record <- restaurants
      JString(displayName) = record \ "displayName"

      JArray(address) = (record \ "address").asInstanceOf[JArray]
      JString(street) = address.head \ "street"
      JString(number) = address.head \ "number"
      JInt(zipcode) = address.head \ "zipcode"
      JString(city) = address.head \ "city"

      JDouble(north) = address.head \ "coordinate" \ "north"
      JDouble(east) = address.head \ "coordinate" \ "east"

    } yield Restaurant(displayName,street,number,zipcode.toString(),city,s"$north:$east")

    restaurantList
  }


}
