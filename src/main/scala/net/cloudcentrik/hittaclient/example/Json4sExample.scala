package net.cloudcentrik.hittaclient.example
import org.json4s._
import org.json4s.jackson.JsonMethods._

object Json4sExample{

  implicit val formats = DefaultFormats

  val json=parse(
    """
      |{
      |  "lotto":{
      |    "lotto-id":5,
      |    "winning-numbers":[2,45,34,23,7,5,3],
      |    "winners":[{
      |      "winner-id":23,
      |      "winner-name":"Joy",
      |      "numbers":[2,45,34,23,3,5]
      |    },{
      |      "winner-id":54,
      |      "winner-name":"Ismail",
      |      "numbers":[52,3,12,11,18,22]
      |    }]
      |  }
      |}
    """.stripMargin

  )

  //println(pretty(render(json)))

  val winners=(json \ "lotto" \ "winners").asInstanceOf[JArray].arr

  val myList: Seq[(BigInt,String)] = for {
    record <- winners
    JInt(id) = record \ "winner-id"
    JString(name) = record \ "winner-name"
  } yield (id,name)

  println(myList)

}
