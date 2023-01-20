package com.sotatek.cardano.ledgersync.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationalCert {

  private String hotKey;
  private Integer sequenceNumber;
  private Integer kesPeriod;
  private String sigma;
}
