package com.sotatek.cardano.ledgersync.common;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ProtocolVersion {
    private long protoMajor;
    private long protoMinor;
}
