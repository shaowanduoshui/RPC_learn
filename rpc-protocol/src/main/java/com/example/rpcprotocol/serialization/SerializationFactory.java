package com.example.rpcprotocol.serialization;

import com.sun.xml.internal.ws.developer.Serialization;

/**
 * @author Yancy.wu
 * @date 2021/10/25
 */
public class SerializationFactory {
    public static RpcSerialization getRpcSerialization(byte serializationType) {
        SerializationTypeEnum typeEnum = SerializationTypeEnum.findByType(serializationType);

        switch (typeEnum) {
            case JSON:
                return new JsonSerialization();
            case HESSIAN:
                return new HessianSerialization();
            default:
                throw new IllegalArgumentException("serialization type is illegal, " + serializationType);
        }

    }
}
