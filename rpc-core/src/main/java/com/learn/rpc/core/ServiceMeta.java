package com.learn.rpc.core;

import lombok.Data;

/**
 * @author Yancy.wu
 * @date 2021/10/12
 */
@Data
public class ServiceMeta {

    private String serviceName;

    private String serviceVersion;

    private String serviceAddr;

    private int servicePort;

}
