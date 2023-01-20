package com.sotatek.cardano.ledgersync.common.byron;

import com.sotatek.cardano.ledgersync.common.kafka.CommonBlock;

public interface ByronBlock extends CommonBlock {

  <T extends ByronHead> T getHeader(); //No Sonar

  <T> T getBody();
}
