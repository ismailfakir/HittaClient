package net.cloudcentrik.hittaclient.view

import net.cloudcentrik.hittaclient.model.{Coordinate, Restaurant}
import scalafx.beans.property.StringProperty
import scalafx.collections.ObservableBuffer
import scalafx.geometry.{Insets, Pos}
import scalafx.scene.control.TableColumn._
import scalafx.scene.control.{TableColumn, TableView}

object HittaTableView {


  val restaurantList = ObservableBuffer[Restaurant](
    /*Restaurant("Vår Krog & Bar","Vårväderstorget", "5","41831","Göteborg","11.891939574381201, 57.712463498578344"),
    Restaurant("Vår Krog & Bar","Vårväderstorget", "5","41831","Göteborg","11.891939574381201, 57.712463498578344"),
    Restaurant("Vår Krog & Bar","Vårväderstorget", "5","41831","Göteborg","11.891939574381201, 57.712463498578344"),
    Restaurant("Vår Krog & Bar","Vårväderstorget", "5","41831","Göteborg","11.891939574381201, 57.712463498578344"),
    Restaurant("Italienska restauranger","Västra Järnvägsgatan", "21","11164","Stockholm","11.891939574381201, 57.712463498578344"),
    Restaurant("Vår Krog & Bar","Vårväderstorget", "5","41831","Göteborg","11.891939574381201, 57.712463498578344"),
    Restaurant("Vår Krog & Bar","Vårväderstorget", "5","41831","Göteborg","11.891939574381201, 57.712463498578344"),
    Restaurant("Vår Krog & Bar","Vårväderstorget", "5","41831","Göteborg","11.891939574381201, 57.712463498578344")*/
  )

  def build = new TableView[Restaurant](restaurantList) {
    padding = Insets(5,10,5,10)
    margin=Insets(10)
    prefHeight=500
    alignmentInParent=Pos.TopCenter
    columns ++= List(
      new TableColumn[Restaurant, String] {
        text = "Name"
        cellValueFactory = _.value.name
        prefWidth = 400
      },
      new TableColumn[Restaurant, String] {
        text = "Street"
        cellValueFactory = _.value.street
        prefWidth = 300
      },
      new TableColumn[Restaurant, String] {
        text = "Number"
        cellValueFactory = _.value.number
        prefWidth = 100
      },
      new TableColumn[Restaurant, String] {
        text = "Zip Code"
        cellValueFactory = _.value.zipCode
        prefWidth = 100
      },
      new TableColumn[Restaurant, String] {
        text = "City"
        cellValueFactory = _.value.city
        prefWidth = 100
      },
      new TableColumn[Restaurant, String] {
        text = "Co-Ordinate"
        cellValueFactory = _.value.coOrdinate
        prefWidth = 400
      }
    )
  }

}
