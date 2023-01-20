package com.sotatek.cardano.ledgersync.common.kafka;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sotatek.cardano.ledgersync.common.Block;
import com.sotatek.cardano.ledgersync.common.Era;
import com.sotatek.cardano.ledgersync.common.byron.ByronEbBlock;
import com.sotatek.cardano.ledgersync.common.byron.ByronMainBlock;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = CommonBlock.TYPE)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Block.class, name = Block.TYPE),
    @JsonSubTypes.Type(value = ByronEbBlock.class, name = ByronEbBlock.TYPE),
    @JsonSubTypes.Type(value = ByronMainBlock.class, name = ByronMainBlock.TYPE),
})
public interface  CommonBlock {

  String TYPE = "type";

  @JsonIgnore
  String getType();

  @JsonIgnore
  String getBlockHash();

  @JsonIgnore
  long getSlot();

  @JsonIgnore
  long getBlockNumber();

  Era getEraType();

  boolean isRollback();

  void setRollback(boolean rollback);

  void setCborSize(int cborSize);

  void setBlockTime(long blockTime);

  void setNetwork(int network);

  void setEraType(Era type);
}
