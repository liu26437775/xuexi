package com.liuli.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyFactory {
    //维护一个目标对象
    private Object target;
    public JdkProxyFactory(Object target){
        this.target=target;
    }

    //给目标对象生成代理对象
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("通过jdk代理执行前处理一些事情...");
                        System.out.println("Method:" + method);
                        Object returnValue = method.invoke(target, args);
                        System.out.println("通过jdk代理执行后处理一些事情...");
                        return returnValue;
                    }
                }
        );
    }
}