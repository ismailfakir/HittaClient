package net.cloudcentrik.hittaclient.view

import java.text.NumberFormat
import java.util.Locale

import scalafx.geometry.Insets
import scalafx.scene.control.{Slider, TextField, TextFormatter}
import scalafx.scene.layout.{Region, VBox}
import scalafx.util.converter.FormatStringConverter

object HittaSlider {
  val slider = new Slider(0, 10000, 1000)

  val textField = {
    val currencyFormat = NumberFormat.getCurrencyInstance(Locale.US)
    val converter = new FormatStringConverter[Number](currencyFormat)
    new TextField {
      textFormatter = new TextFormatter(converter) {
        value <==> slider.value
      }
      maxWidth = 140
      maxHeight = Region.USE_COMPUTED_SIZE
    }
  }

  def build=HittaPanel.buildVerticalBox(List(textField,slider))
}
