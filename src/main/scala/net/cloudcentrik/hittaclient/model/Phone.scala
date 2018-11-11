package net.cloudcentrik.hittaclient.model

import com.fasterxml.jackson.annotation.JsonProperty

case class Phone (
                   @JsonProperty("label") label: String,
                   @JsonProperty("callTo") callTo: String,
                   @JsonProperty("displayAs") displayAs: String
                 )
