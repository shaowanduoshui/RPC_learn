package com.learn.rpc.core;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Yancy.wu
 * @date 2021/10/12
 */
@Data
public class RpcRequest implements Serializable {
    private String serviceVersion;
    private String className;
    private String methodName;
    private Object[] params;
    private Class<?>[] parameterTypes;
}
