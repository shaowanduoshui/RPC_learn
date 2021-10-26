package com.example.rpcprotocol.protocol;

import lombok.Getter;

/**
 * @author Yancy.wu
 * @date 2021/10/25
 */
public enum MsgStatus {
    SUCCESS(0),
    FAIL(1);

    @Getter
    private final int code;

    MsgStatus(int code) {
        this.code = code;
    }
}
