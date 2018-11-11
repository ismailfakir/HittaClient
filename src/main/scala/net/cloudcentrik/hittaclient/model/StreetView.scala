package net.cloudcentrik.hittaclient.model

import com.fasterxml.jackson.annotation.JsonProperty

case class StreetView(
                       @JsonProperty("row") row: Int,
                       @JsonProperty("col") column: Int,
                       @JsonProperty("type") viewType:String,
                       @JsonProperty("uri") uri:String,
                       @JsonProperty("angle") angle:Double,
                       @JsonProperty("isVideoAvailable") isVideoAvailable:Boolean,
                       @JsonProperty("coordinate") coordinate: Coordinate
                     )
