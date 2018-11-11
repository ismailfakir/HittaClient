package net.cloudcentrik.hittaclient.view

import scalafx.geometry.Insets
import scalafx.scene.control.{ContentDisplay, Label, TextField}
import scalafx.scene.layout.HBox

object HittaTextBox {

  def build(name:String,size:Int)=new HBox {
    spacing = 5
    padding = Insets(5)
    children = List(
      new Label {
        text = name
        contentDisplay = ContentDisplay.Center
        maxWidth = 200
      },
      new TextField {
        promptText = name
        minWidth=size
        maxWidth = 200
      })
  }

}
