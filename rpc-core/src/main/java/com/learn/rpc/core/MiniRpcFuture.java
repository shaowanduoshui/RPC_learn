package com.learn.rpc.core;

import io.netty.util.concurrent.Promise;
import lombok.Data;

/**
 * @author Yancy.wu
 * @date 2021/10/12
 */
@Data
public class MiniRpcFuture<T> {
    private Promise<T> promise;
    private long timeout;

    public MiniRpcFuture(Promise<T> promise, long timeout) {
        this.promise = promise;
        this.timeout = timeout;
    }
}
