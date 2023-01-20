package com.sotatek.cardano.ledgersync.common.byron;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class ByronSscProof {
  private String payloadProof;
  private String certificatesProof;
}
