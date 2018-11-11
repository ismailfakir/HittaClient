package net.cloudcentrik.hittaclient.utils

object StringUtils {

  def normalizedAddress(address:String):String={

    address.toLowerCase
      .replaceAll("å","oe")
      .replaceAll("ä","ae")
      .replaceAll("ö","oo")
      .replaceAll(" ","")
      .trim

  }

}
