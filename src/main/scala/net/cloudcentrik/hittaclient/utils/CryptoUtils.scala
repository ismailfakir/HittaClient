package net.cloudcentrik.hittaclient.utils

object CryptoUtils {

  def sha1Hash(message:String):String={
    val md = java.security.MessageDigest.getInstance("SHA-1")
    md.digest(message.getBytes("UTF-8")).map("%02x".format(_)).mkString
  }

}
