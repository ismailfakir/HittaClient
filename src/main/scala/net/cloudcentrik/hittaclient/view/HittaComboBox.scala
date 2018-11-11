package net.cloudcentrik.hittaclient.view

import scalafx.collections.ObservableBuffer
import scalafx.scene.control.ComboBox

object HittaComboBox{

  def build(list: Seq[String])=new ComboBox[String] {
    minWidth=200
    maxWidth=400
    promptText = "Make a choice..."
    items = ObservableBuffer(list)
  }

}
