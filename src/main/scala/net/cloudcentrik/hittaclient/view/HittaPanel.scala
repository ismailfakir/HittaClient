package net.cloudcentrik.hittaclient.view

import scalafx.geometry.{Insets, NodeOrientation, Orientation}
import scalafx.scene.control.Control
import scalafx.scene.layout._

object HittaPanel {

  def build(exises: Orientation,list: List[Control]) = new TilePane {
    padding = Insets(10)
    orientation = exises
    hgap = 5
    vgap = 5
    children = list

  }

  def buildVertical(list: List[Pane]) = new VBox{
    vgrow = Priority.Always
    hgrow = Priority.Always
    spacing = 10
    padding = Insets(20)
    children = list
  }

  def buildHorizontal(list: List[Pane]) = new HBox{
    vgrow = Priority.Always
    hgrow = Priority.Always
    spacing = 10
    padding = Insets(20)
    children = list
  }

  def buildVerticalBox(list: List[Control]) = new VBox{
    vgrow = Priority.Always
    hgrow = Priority.Always
    spacing = 10
    padding = Insets(20)
    children = list
  }

  def buildHorizontalBox(list: List[Control]) = new HBox{
    vgrow = Priority.Always
    hgrow = Priority.Always
    spacing = 10
    padding = Insets(20)
    children = list
  }

}


