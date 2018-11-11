package net.cloudcentrik.hittaclient.view

import akka.http.scaladsl.model.headers.LinkParams.title
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType
import scalafx.stage.Stage

object HittaAlert {

  def build(stage:Stage,alertTitle:String,header:String,message:String)=new Alert(AlertType.Information) {
    initOwner(stage)
    title = alertTitle
    headerText = header
    contentText = message
  }

}
