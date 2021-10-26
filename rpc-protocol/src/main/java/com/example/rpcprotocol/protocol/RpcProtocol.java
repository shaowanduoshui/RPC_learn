package com.example.rpcprotocol.protocol;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Yancy.wu
 * @date 2021/10/25
 */
@Data
public class RpcProtocol<T> implements Serializable {
    private MsgHeader header;
    private T body;
}
