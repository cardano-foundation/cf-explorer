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
public class ByronEbBlock extends AbstractBlock implements ByronBlock{

    public static final String TYPE = "ByronEbBlock";

    private ByronEbHead header;
    private ByronEbBody body;

    @Override
    public String getType() {
        return TYPE;
    }


    @Override
    public String getBlockHash() {
        return header.getBlockHash();
    }

    @Override
    public long getSlot() {
        return header.getConsensusData().getEpochId() * 21600;
    }

    @Override
    public long getBlockNumber() {
        return 0;
    }


    public ByronEbHead getHeader() {
        return header;
    }
}
