package com.example.rpcregistry;

import com.learn.rpc.core.ServiceMeta;

import java.io.IOException;

/**
 * @author Yancy.wu
 * @date 2021/10/12
 */
public interface RegistryService {

    void register(ServiceMeta serviceMeta) throws Exception;

    void unRegister(ServiceMeta serviceMeta) throws Exception;

    ServiceMeta discovery(String serviceName, int invokerHashCode) throws Exception;

    void destroy() throws IOException;

}
