package com.example.rpcprotocol.protocol;

import lombok.Getter;

/**
 * @author Yancy.wu
 * @date 2021/10/25
 */
public enum MsgType {
    REQUEST(1),
    RESPONSE(2),
    HEARTBEAT(3);

    @Getter
    private final int type;

    MsgType(int type) {
        this.type = type;
    }

    public static MsgType findByType(int type) {
        for (MsgType msgtype : MsgType.values()) {
            if (msgtype.getType() == type) {
                return msgtype;
            }
        }
        return null;
    }
}