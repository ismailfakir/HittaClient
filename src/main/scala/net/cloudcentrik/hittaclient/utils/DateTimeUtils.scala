package net.cloudcentrik.hittaclient.utils

object DateTimeUtils {

  private val dateFormat = "yyyy-MM-dd HH:mm:ss"

  def now():String ={
    import java.time.Instant
    Instant.now.getEpochSecond.toString
  }

}
