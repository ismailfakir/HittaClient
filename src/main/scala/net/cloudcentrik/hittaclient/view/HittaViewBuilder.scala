package net.cloudcentrik.hittaclient.view

import scalafx.event.ActionEvent
import scalafx.geometry.Orientation
import scalafx.scene.control.TextField
import scalafx.scene.layout.{HBox, TilePane, VBox}

object HittaViewBuilder {

  def buildTestPanel:TilePane={

    //passing function as a method parameter
    val button1=HittaButton.build("login",action)
    val button2=HittaButton.build("logout",action)

    HittaPanel.build(Orientation.Horizontal,List(button1,button2))
  }

  def buildTestPanel1:TilePane={

    //passing function as a method parameter
    val button1=HittaButton.build("login",action)
    val button2=HittaButton.build("logout",action)

    HittaPanel.build(Orientation.Vertical,List(button1,button2))
  }

  def buildHorizontalBoxPanel:HBox={

    val textBox1=HittaTextBox.build("name",150);
    val textBox2=HittaTextBox.build("email",150);
    val textBox3=buildTestPanel1

    HittaPanel.buildHorizontal(List(textBox1,textBox2,textBox3))
  }

  def buildVerticalBoxPanel:VBox={

    val textBox1=HittaTextBox.build("name",150);
    val textBox2=HittaTextBox.build("email",150);
    val textBox3=buildTestPanel

    HittaPanel.buildVertical(List(textBox1,textBox2,textBox3))
  }

  //button action for HittaButton
  def action(action:ActionEvent)={
    println("button cliecked")

  }

  def buildTopPanel(setResponseAction: ActionEvent => Unit)={
    val choice=Seq(
      "what=pizza&where=stockholm&page.number=1&",
      "persons?what=secker&page.number=1&page.size=1",
      "companies/trade/501/nearby/6581162:1626938?geo.distance=500"
    )
    val label=HittaLabel.build("Address")
    val choiceList=HittaComboBox.build(choice)

    val requestButon=HittaButton.build("GET RESPONSE",setResponseAction)

    val childrenList=List(label,choiceList,requestButon)

    HittaPanel.buildHorizontalBox(childrenList)

  }

}
