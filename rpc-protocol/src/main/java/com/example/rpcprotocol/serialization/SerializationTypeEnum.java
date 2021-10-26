package com.example.rpcprotocol.serialization;

import lombok.Getter;

/**
 * @author Yancy.wu
 * @date 2021/10/25
 */
public enum SerializationTypeEnum {
    HESSIAN(0x10),
    JSON(0x20);

    @Getter
    private final int type;

    SerializationTypeEnum(int type) {
        this.type = type;
    }

    public static SerializationTypeEnum findByType(byte serializationType) {
        for (SerializationTypeEnum typeEnum : SerializationTypeEnum.values()) {
            if (typeEnum.getType() == serializationType) {
                return typeEnum;
            }
        }
        return HESSIAN;
    }
}