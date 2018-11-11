package net.cloudcentrik.hittaclient.view

import scalafx.scene.control.{Menu, MenuBar, MenuItem}

object HittaMenuBar {

  def build = new MenuBar {
    menus = List(
      new Menu("File") {
        items = List(
          new MenuItem("New..."),
          new MenuItem("Save")
        )
      },
      new Menu("Edit") {
        items = List(
          new MenuItem("Cut"),
          new MenuItem("Copy"),
          new MenuItem("Paste")
        )

      },
      new Menu("Help") {
        items = List(
          new MenuItem("About")
        )
      }
    )
  }

}
