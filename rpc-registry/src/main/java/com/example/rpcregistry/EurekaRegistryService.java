package com.example.rpcregistry;

import com.learn.rpc.core.ServiceMeta;

import java.io.IOException;

/**
 * @author Yancy.wu
 * @date 2021/10/12
 */
public class EurekaRegistryService implements RegistryService{

    public EurekaRegistryService(String registryAddr) {
        // TODO
    }

    @Override
    public void register(ServiceMeta serviceMeta) throws Exception {

    }

    @Override
    public void unRegister(ServiceMeta serviceMeta) throws Exception {

    }

    @Override
    public ServiceMeta discovery(String serviceName, int invokerHashCode) throws Exception {
        return null;
    }

    @Override
    public void destroy() throws IOException {

    }
}
