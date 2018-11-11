package net.cloudcentrik.hittaclient.service

import net.cloudcentrik.hittaclient.utils.{CryptoUtils, DateTimeUtils, RandomUtils}
import com.softwaremill.sttp._
import net.cloudcentrik.hittaclient.configuration.HittaConfiguration

object HittaClientUtils {

  val baseUrl="https://api.hitta.se/"

  val credential=HittaConfiguration.loadAPICredential
  val callerId=credential._1 //id
  val key=credential._2 //key

  val time=DateTimeUtils.now()
  val random=RandomUtils.randomString(16)
  val hash=CryptoUtils.sha1Hash(callerId + time + key + random)

  val headers=Map(
    ("X-Hitta-CallerId",callerId),
    ("X-Hitta-Time",time),
    ("X-Hitta-Random",random),
    ("X-Hitta-Hash",hash),
    (HeaderNames.ContentType,MediaTypes.Json),
    (HeaderNames.Accept,MediaTypes.Json)
  )

}
