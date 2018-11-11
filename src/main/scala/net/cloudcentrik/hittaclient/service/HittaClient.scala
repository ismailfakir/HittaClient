package net.cloudcentrik.hittaclient.service

import com.softwaremill.sttp._
import net.cloudcentrik.hittaclient.utils.{JsonUtils, StringUtils}
import org.json4s._
import org.json4s.jackson.JsonMethods._


object HittaClient {

  def getJson(path: List[String], params: Map[String, String]): JValue = {

    var json: JValue = null
    val baseUrl = HittaClientUtils.baseUrl

    val uri = uri"$baseUrl$path?$params"

    val request = sttp.
      headers(HittaClientUtils.headers).
      get(uri)

    implicit val backend = HttpURLConnectionBackend()
    implicit val formats = DefaultFormats


    val response = request.send()


    if (response.code == StatusCodes.Ok) {
      //json = parse(response.body.getOrElse().toString).asInstanceOf[JObject]
      json = parse(response.body.getOrElse().toString)
      //println(pretty(json))
    }

    json
  }

  def findPizza(pointX: String, pointY: String, distance: String): JValue = {
    val tradeId = "284" //Pizzerior
    val point = s"$pointX:$pointY~WGS84"

    val path = List("publicsearch", "v1", "companies", "trade", tradeId, "nearby", point)

    val params = Map(
      ("geo.distance", distance),
      ("trade.max.count", "100"),
      ("geo.system", "WGS84")
    )

    HittaClient.getJson(path, params)
  }

  def findRestaurant(address: String, tradeId:String,distance: String): JValue = {

    val jsonAddress:JValue= HittaClient.findAddress(address)

    //val point = "57.711710:11.887619~WGS84"
    val point = JsonUtils.findCoOrdinate(jsonAddress)
    print(point)

    /*
    * todo http://hitta.github.io/public/http-api/geo/coordinate-convert.html convert the co-ordinate
     */


    val path = List("publicsearch", "v1", "companies", "trade", tradeId, "nearby", point)

    val params = Map(
      ("geo.distance", distance),
      ("trade.max.count", "100"),
      ("geo.system", "RT90")
    )

    HittaClient.getJson(path, params)
  }

  def findAddress(address: String): JValue = {

    val path = List("publicsearch", "v1", "address",StringUtils.normalizedAddress(address))

    val params = Map(
      ("geo.system", "RT90")
    )

    HittaClient.getJson(path, params)
  }



}
