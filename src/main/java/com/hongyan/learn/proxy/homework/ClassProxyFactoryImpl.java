/**
 * Baijiahulian.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.hongyan.learn.proxy.homework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
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

        Constructor constructor = originalInstance.getClass().getConstructor(InvocationHandler.class);

        class MyHandler implements InvocationHandler {
            private ClassProxy classProxy;

            public MyHandler(ClassProxy classProxy) {
                this.classProxy = classProxy;
            }
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // TODO Auto-generated method stub
                return this.classProxy.intercept(method, proxy, args);
            }

        }

        Object res = constructor.newInstance(new MyHandler(proxy));
        
        return res;
    }

}
