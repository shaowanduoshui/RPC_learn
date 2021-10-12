package com.learn.rpc.core;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Yancy.wu
 * @date 2021/10/12
 */
@Data
@ConfigurationProperties(prefix = "rpc")
public class RpcProperties {

    private int servicePort;

    private String registryAddr;

    private String registryType;

}