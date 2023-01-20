package com.sotatek.cardano.ledgersync.common;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class BlockVersion {

  private short major;
  private short minor;
  private byte alt;
}
