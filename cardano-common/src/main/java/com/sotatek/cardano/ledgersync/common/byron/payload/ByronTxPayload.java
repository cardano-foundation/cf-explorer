package com.sotatek.cardano.ledgersync.common.byron.payload;

import com.sotatek.cardano.ledgersync.common.byron.ByronTx;
import com.sotatek.cardano.ledgersync.common.byron.ByronTxWitnesses;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class ByronTxPayload {

  private ByronTx transaction;
  private List<ByronTxWitnesses> witnesses;
}
