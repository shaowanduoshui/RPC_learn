package com.example.rpcprovider.facade;

import com.example.rpcprovider.annotation.RpcService;
import com.learn.rpc.facade.HelloFacade;

/**
 * @author Yancy.wu
 * @date 2021/12/31
 */
@RpcService(serviceInterface = HelloFacade.class, serviceVersion = "1.0.0")
public class HelloFacadeImpl implements HelloFacade {
    @Override
    public String hello(String name) {
        return "hello" + name;
    }
}
