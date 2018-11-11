package net.cloudcentrik.hittaclient.model

import com.fasterxml.jackson.annotation.JsonProperty

case class Trade(@JsonProperty("name") name: String, @JsonProperty("id") id: Int)
