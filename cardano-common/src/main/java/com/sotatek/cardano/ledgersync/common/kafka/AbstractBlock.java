package com.sotatek.cardano.ledgersync.common.kafka;


import com.sotatek.cardano.ledgersync.common.Era;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractBlock implements CommonBlock {
  protected int cborSize;
  private Era eraType;
  private long blockTime;
  private int network;
  private boolean rollback;


}
