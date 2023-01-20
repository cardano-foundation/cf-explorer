package com.sotatek.cardano.ledgersync.common;



import com.bloxbean.cardano.client.transaction.spec.PlutusScript;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sotatek.cardano.ledgersync.common.kafka.serializer.PlutusScriptDeserializer;
import com.sotatek.cardano.ledgersync.common.nativescript.NativeScript;
import java.math.BigDecimal;
import java.util.Map;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class AuxData {

  private Map<BigDecimal, String> metadataCbor;
  private String metadataJson;

  private List<NativeScript> nativeScripts;

  @JsonDeserialize(contentUsing = PlutusScriptDeserializer.class)
  private List<PlutusScript> plutusV1Scripts;

  @JsonDeserialize(contentUsing = PlutusScriptDeserializer.class)
  private List<PlutusScript> plutusV2Scripts;
}
