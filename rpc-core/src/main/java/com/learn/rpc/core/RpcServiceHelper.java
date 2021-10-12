package com.learn.rpc.core;

/**
 * @author Yancy.wu
 * @date 2021/10/12
 */
public class RpcServiceHelper {
    public static String buildServiceKey(String serviceName, String serviceVersion) {
        return String.join("#", serviceName, serviceVersion);
    }
}
