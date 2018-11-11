package net.cloudcentrik.hittaclient.configuration
import com.typesafe.config._

import scala.io.Source

object HittaConfiguration{

  def getApplicationName={
    val conf = ConfigFactory.load()
    conf.getString("app-name")
  }

  def parseApiCredential={

    val conf = ConfigFactory.load()

    val fileName=conf.getString("api-credentials-file-name")

    var callerId:String=null
    var key:String=null
    val bufferedSource = Source.fromFile(fileName)
    for (line <- bufferedSource.getLines) {
      if(line.startsWith("CALLER_ID")){
        callerId=line.split("CALLER_ID=")(1)
      }
      if(line.startsWith("KEY")){
        key=line.split("KEY=")(1)
      }

    }

    bufferedSource.close

    (callerId,key)
  }

  def loadAPICredential={
    val conf = ConfigFactory.load()
    (conf.getString("api.id"),conf.getString("api.key"))
  }


}
