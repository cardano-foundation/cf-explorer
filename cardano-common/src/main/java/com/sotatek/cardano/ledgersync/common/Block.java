package com.sotatek.cardano.ledgersync.common;

import com.sotatek.cardano.ledgersync.common.kafka.AbstractBlock;
import lombok.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Builder
public class Block extends AbstractBlock {

  public static final String TYPE = "Block";


  private boolean rool;

  private BlockHeader header;

  @Builder.Default
  private List<TransactionBody> transactionBodies = new ArrayList<>();

  private List<Witnesses> transactionWitness = new ArrayList<>();
  private Map<Integer, AuxData> auxiliaryDataMap = new LinkedHashMap<>();
  private List<Integer> invalidTransactions = new ArrayList<>();
  private List<Object> transactionMetadataSet;

  @Override
  public String getType() {
    return TYPE;
  }

  @Override
  public String getBlockHash() {
    return getHeader().getHeaderBody().getBlockHash();
  }

  @Override
  public long getSlot() {
    return getHeader().getHeaderBody().getSlotId().getSlotId();
  }

  @Override
  public long getBlockNumber() {
    return getHeader().getHeaderBody().getBlockNumber();
  }

}
