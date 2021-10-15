package com.example.rpcregistry;

import java.util.List;

/**
 * @author Yancy.wu
 * @date 2021/10/12
 */
public interface ServiceLoadBalancer<T> {
    T select(List<T> servers,int hashCode);
}
