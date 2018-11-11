package net.cloudcentrik.hittaclient.view

import org.json4s._
import org.json4s.jackson.JsonMethods._
import net.cloudcentrik.hittaclient.App.stage
import net.cloudcentrik.hittaclient.configuration.HittaConfiguration
import net.cloudcentrik.hittaclient.model.{Coordinate, Restaurant}
import net.cloudcentrik.hittaclient.service.HittaClient
import net.cloudcentrik.hittaclient.utils.JsonUtils
import org.json4s.JsonAST.JValue
import org.json4s.{DefaultFormats, JObject}
import scalafx.application.JFXApp
import scalafx.collections.ObservableBuffer
import scalafx.event.ActionEvent
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.TextArea
import scalafx.scene.layout.VBox

object HittaMainView {

  val viewWidth=1400
  val viewHeight=600

  val trade=List(
    ("Pizzerior","284"),
    ("Thairestauranger","506"),
    ("Indiska restauranger","507"),
    ("Italienska restauranger","501"),
    ("Franska restauranger","503"),
    ("Grekiska restauranger","511"),
    ("Kinesiska restauranger","509"),
    ("Sushirestauranger","508"),
    ("Svenska restauranger","505")
  )

  val meter=List(
    ("500 meter","500"),
    ("1 kilometer","1000"),
    ("1.5 kilometer","1500"),
    ("2 kilometer","2000")
  )

  val categories=trade.map(x => x._1).toSeq
  val distances=meter.map(x => x._1).toSeq

  val addressTextField=HittaTextField.build("address",400)
  val categoriesComboBox=HittaComboBox.build(categories)
  val distancesComboBox=HittaComboBox.build(distances)

  val jsonText:TextArea=HittaTextArea.build(30,"")

  val restaurantTable=HittaTableView.build


  def show={

    val mainLayout = new VBox {
      padding = Insets(10, 10, 10, 10)
      children = List(HittaMenuBar.build,buildTopPanel,restaurantTable)
      style=HittaStyle.borderStyle
    }

    val mainScene = new Scene(mainLayout, viewWidth, viewHeight)
    mainScene.stylesheets= List(getClass.getResource("hitta-styles.css").toExternalForm)

    stage = new JFXApp.PrimaryStage {
      scene = mainScene
      title = HittaConfiguration.getApplicationName
    }
    //stage.setMaximized(true)
    stage.show

  }

  def buildTopPanel={

    val addressLabel=HittaLabel.build("Address")
    val categoriesLabel=HittaLabel.build("Category")
    val distancesLabel=HittaLabel.build("Distance")

    addressTextField.text="Kungsgatan 32 Göteborg"

    val findButon=HittaButton.build("Find",findButtonAction)

    val childrenList=List(addressLabel,addressTextField,categoriesLabel,categoriesComboBox,distancesLabel,distancesComboBox,findButon)

    HittaPanel.buildHorizontalBox(childrenList)

  }

  def findButtonAction(action:ActionEvent)={

    val address=addressTextField.getText
    val category=categoriesComboBox.getValue
    val distance=distancesComboBox.getValue

    val jsonAddress:JValue= HittaClient.findRestaurant(address,findTradeIdFromName(category),findDistanceFromName(distance))

    val restaurantList:List[Restaurant]=JsonUtils.parseRestaurantList(jsonAddress)

    restaurantTable.getItems.removeAll()
    restaurantTable.setItems(updateTableData(restaurantList))
    restaurantTable.refresh()

  }

  def findTradeIdFromName(name:String):String={
    trade.filter(p=>name.equals(p._1)).head._2
  }

  def findDistanceFromName(name:String):String={
    meter.filter(p=>name.equals(p._1)).head._2
  }

  def updateTableData(restaurantList:List[Restaurant]):ObservableBuffer[Restaurant]={
    val list=new ObservableBuffer[Restaurant]
    restaurantList.foreach(e=>list.add(e))
    list
  }



}
