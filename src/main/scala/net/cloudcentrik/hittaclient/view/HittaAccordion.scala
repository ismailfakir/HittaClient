package net.cloudcentrik.hittaclient.view

import scalafx.geometry.Insets
import scalafx.scene.control._
import scalafx.scene.layout.StackPane

object HittaAccordion {

  def build = new StackPane {
    padding = Insets(10)
    children = new Accordion {
      //maxWidth = 150
      //maxHeight = 150
      panes = List(
        new TitledPane {
          text = "Ensemble Button 1"
          children = new Button("Button 1")
        },
        new TitledPane {
          text = "Ensemble TextField 1"
          children = new TextField {
            promptText = "Hi! Scalafx Ensemble!"
          }
        }, new TitledPane {
          text = "Ensemble CheckBox 1"
          children = new CheckBox {
            text = "CheckBox 1"
          }
        })
    }
  }

}
