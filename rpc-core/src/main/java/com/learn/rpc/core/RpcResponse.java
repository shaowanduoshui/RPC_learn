package com.learn.rpc.core;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Yancy.wu
 * @date 2021/10/12
 */
@Data
public class RpcResponse implements Serializable {
    private Object data;
    private String message;
}

