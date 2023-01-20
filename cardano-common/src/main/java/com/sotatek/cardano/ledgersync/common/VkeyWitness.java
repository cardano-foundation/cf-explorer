package com.sotatek.cardano.ledgersync.common;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class VkeyWitness {

  private String key;
  private String signature;
}
