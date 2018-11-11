package net.cloudcentrik.hittaclient.utils

import java.net.{InetAddress, NetworkInterface}

object IPUtils {

  def printIP:Unit={

    val addr = scala.io.Source.fromURL("https://api.ipify.org").mkString
    println(s"My public IP address is: $addr")

    val addr1 = scala.io.Source.fromURL("http://ip-api.com/json").mkString
    println(s"My public IP address is: $addr1")

  }

}
