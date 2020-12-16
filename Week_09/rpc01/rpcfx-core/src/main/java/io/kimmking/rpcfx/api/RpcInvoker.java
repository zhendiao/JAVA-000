package io.kimmking.rpcfx.api;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;

import java.lang.reflect.InvocationTargetException;

public   class RpcInvoker {
    public static <T> T create(final Class<T> serviceClass, final String url) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return (T) new ByteBuddy().subclass(Object.class)
                .implement(serviceClass)
                .intercept(InvocationHandlerAdapter.of(new io.kimmking.rpcfx.proxy.RpcfxInvocationHandler(serviceClass, url)))
                .make()
                .load(serviceClass.getClassLoader())
                .getLoaded()
                .getDeclaredConstructor()
                .newInstance();
    }
}
