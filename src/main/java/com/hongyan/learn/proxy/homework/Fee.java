/**
 * Baijiahulian.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.hongyan.learn.proxy.homework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @title Fee
 * @desc description
 * @author hongyan
 * @date 2016年8月4日
 * @version version
 */

public class Fee {
    public String hello() {
        return "hello fee";
    }

    public static Object createProxy(Object originalInstance, ClassProxy proxy) {
        return null;
    }
    /**
     * (currentMethod, originalInstance, args) -> {
            Object ret = currentMethod.invoke(originalInstance, args);
            return ret + " intercept 1";
        }
     * @param args
     * @throws Throwable 
     */

    public static void main(String[] args) throws Throwable {
        Fee fee = (Fee) createProxy(new Fee(), new ClassProxy() {
            @Override
            public Object intercept(Method currentMethod, Object originalInstance, Object[] args) {
                Object ret = null;
                try {
                    ret = currentMethod.invoke(originalInstance, args);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return ret + " intercept 1";
            }
        });

        System.out.println(fee.hello());
    }
    }


