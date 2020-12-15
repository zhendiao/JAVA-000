package io.kimmking.rpcfx.api;

public  abstract class RpcInvoker<T> {
    public abstract Object invoke(T instance, String method, Object[] params);
}
