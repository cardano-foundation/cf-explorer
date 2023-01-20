package com.sotatek.cardano.ledgersync.common.byron;

import com.sotatek.cardano.ledgersync.common.kafka.AbstractBlock;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class ByronMainBlock extends AbstractBlock implements ByronBlock {

    public static final String TYPE = "ByronMainBlock";

    private ByronBlockHead header;
    private ByronMainBody body;

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String getBlockHash() {
        return getHeader().getBlockHash();
    }

    @Override
    public long getSlot() {
        return getHeader().getConsensusData().getSlotId().getSlotId();
    }

    @Override
    public long getBlockNumber() {
        return getHeader().getConsensusData().getDifficulty().longValue();
    }


    public ByronBlockHead getHeader() {
        return header;
    }
}
