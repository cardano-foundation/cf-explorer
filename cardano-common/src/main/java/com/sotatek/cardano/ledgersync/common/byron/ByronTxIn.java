package com.sotatek.cardano.ledgersync.common.byron;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class ByronTxIn {

  private String txId;
  private int index;
}
