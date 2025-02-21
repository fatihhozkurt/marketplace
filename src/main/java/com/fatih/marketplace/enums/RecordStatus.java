package com.fatih.marketplace.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RecordStatus {
    ACTIVE(true),
    PASSIVE(false);

    private final boolean status;
}
