package com.sotatek.cardano.ledgersync.common.byron;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class ByronTxProof {

  private long txpNumber;
  private String txpRoot;
  private String txpWitnessesHash;
}
