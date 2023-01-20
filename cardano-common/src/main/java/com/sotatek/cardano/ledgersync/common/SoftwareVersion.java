package com.sotatek.cardano.ledgersync.common;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class SoftwareVersion {

  private String appName;
  private long number;
}
