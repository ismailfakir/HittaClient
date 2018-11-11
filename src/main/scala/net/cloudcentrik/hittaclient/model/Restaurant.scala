package net.cloudcentrik.hittaclient.model

import scalafx.beans.property.StringProperty

case class Restaurant(_name:String,_street:String,_number:String,_zipCode:String,_city:String,_coOrdinate: String) {
  val name = new StringProperty(this, "name",_name)
  val street = new StringProperty(this, "street",_street)
  val number = new StringProperty(this, "number",_number)
  val zipCode = new StringProperty(this, "zipCode",_zipCode)
  val city = new StringProperty(this, "city",_city)
  val coOrdinate = new StringProperty(this, "coOrdinate",_coOrdinate)
}
