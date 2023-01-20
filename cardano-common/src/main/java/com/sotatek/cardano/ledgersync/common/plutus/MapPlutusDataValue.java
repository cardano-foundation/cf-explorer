package com.sotatek.cardano.ledgersync.common.plutus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MapPlutusDataValue {
  @JsonProperty("v")
  private PlutusData value;
}
