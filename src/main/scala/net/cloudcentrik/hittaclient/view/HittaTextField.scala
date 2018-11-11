package net.cloudcentrik.hittaclient.view

import scalafx.scene.control.TextField

object HittaTextField {

  def build(name:String,size:Int)=new TextField {
    promptText = name
    minWidth=size
    maxWidth = 600
    id="hitta-textField"
  }

}
