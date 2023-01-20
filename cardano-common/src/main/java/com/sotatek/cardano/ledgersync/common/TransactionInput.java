package com.sotatek.cardano.ledgersync.common;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class TransactionInput {

  private String transactionId;
  private int index;
}
