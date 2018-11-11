package net.cloudcentrik.hittaclient.view

import scalafx.geometry.Insets
import scalafx.scene.control.TextArea
import scalafx.scene.paint.Color._
import scalafx.scene.paint.{Color, LinearGradient, Stops}

object HittaTextArea {

  def build(rowCount:Int,json:String)=new TextArea(){
    text=json
    padding = Insets(5, 5, 5, 5)
    prefRowCount=rowCount
    style = "-fx-font-size: 16pt"
    id="hitta-textArea"
  }


}
