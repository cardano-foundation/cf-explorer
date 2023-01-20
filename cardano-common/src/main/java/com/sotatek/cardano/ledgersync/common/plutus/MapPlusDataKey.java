package com.sotatek.cardano.ledgersync.common.plutus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sotatek.cardano.ledgersync.common.kafka.MapKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MapPlusDataKey extends MapKey {

  @JsonProperty("k")
  private PlutusData key;

}
