package net.cloudcentrik.hittaclient.view

import scalafx.event.ActionEvent
import scalafx.geometry.Insets
import scalafx.scene.control.Button
import scalafx.Includes._

object HittaButton {


  def build(name:String,action: ActionEvent => Unit) = new Button {
    text = name
    padding = Insets(5,10,5,10)
    id="hitta-dark-blue-button"
    //style=HittaStyle.buttonStyle
    //margin=Insets(10)
    //minHeight=20
    minWidth=150
    defaultButton = true
    onAction=(event: ActionEvent) =>  {
      /*Do something*/
      action(event)
    }
  }

}
