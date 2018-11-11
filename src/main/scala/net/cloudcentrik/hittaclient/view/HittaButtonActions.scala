package net.cloudcentrik.hittaclient.view

import akka.http.scaladsl.model.headers.LinkParams.title
import scalafx.event.ActionEvent
import scalafx.scene.control.Alert
import scalafx.scene.control.Alert.AlertType

object HittaButtonActions {

  //button action for HittaButton
  def action(action:ActionEvent)={
    println("button cliecked")
    new Alert(AlertType.Information) {
      title = "Information Dialog"
      headerText = "Look, an Information Dialog"
      contentText = "I have a great message for you!"
    }.showAndWait()
  }

}
