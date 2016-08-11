/**
 * Baijiahulian.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.hongyan.learn.proxy.homework;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @title ClassProxyFactoryImpl
 * @desc description
 * @author hongyan
 * @date 2016年8月5日
 * @version version
 */
public class ClassProxyFactoryImpl implements ClassProxyFactory {

    @Override
    public Object createProxy(Object originalInstance, ClassProxy proxy) throws Throwable {
        class MyInterceptor implements MethodInterceptor {
            private ClassProxy prox;

            public MyInterceptor(ClassProxy prox) {
                this.prox = prox;
            }
            @Override
            public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
                return this.prox.intercept(arg3, arg0, arg2);
                // return arg3.invokeSuper(arg0, arg2);
            }
        }
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(originalInstance.getClass());
        enhancer.setCallback(new MyInterceptor(proxy));
        return enhancer.create();
    }

}
