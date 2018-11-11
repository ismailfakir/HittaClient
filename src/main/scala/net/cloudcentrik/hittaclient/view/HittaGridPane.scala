package net.cloudcentrik.hittaclient.view

import scalafx.geometry.{Insets, Pos}
import scalafx.scene.control.Control
import scalafx.scene.layout.GridPane

object HittaGridPane {

  def build(list: List[Control],noOfColumn:Int)=new GridPane() {
    hgap = 10
    vgap = 10
    padding = Insets(10, 10, 10, 10)
    alignment = Pos.BottomRight

    var x=0
    var y=0

    list.foreach(e=>{
      if(x<noOfColumn){
        add(e,x,y)
        y+=1
      }else{
        y=0
        x+=1
        add(e,x,y)
      }

    })
  }

}
