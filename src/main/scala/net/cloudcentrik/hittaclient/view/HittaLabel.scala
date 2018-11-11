package net.cloudcentrik.hittaclient.view

import scalafx.geometry.Insets
import scalafx.scene.control.Label

object HittaLabel {

  def build(name:String) = new Label {
    text = name
    padding = Insets(5,10,5,10)
    id="hitta-label"
  }

}
