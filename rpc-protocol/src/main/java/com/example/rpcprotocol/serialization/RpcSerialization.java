package com.example.rpcprotocol.serialization;

import java.io.IOException;

/**
 * @author Yancy.wu
 * @date 2021/10/25
 */
public interface RpcSerialization {
    <T> byte[] serialize(T obj) throws IOException;

    <T> T deserialize(byte[] data, Class<T> clz) throws IOException;

}
