package net.cloudcentrik.hittaclient.model

import com.fasterxml.jackson.annotation.JsonProperty

case class Coordinate(
                       @JsonProperty("north") north: Double,
                       @JsonProperty("east") east: Double,
                       @JsonProperty("system") system: String
                     )
