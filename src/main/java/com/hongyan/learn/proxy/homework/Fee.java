/**
 * Baijiahulian.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.hongyan.learn.proxy.homework;

import java.lang.reflect.InvocationTargetException;

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

    public static void main(String[] args) throws Throwable {
        Fee fee = (Fee) createProxy(new Fee(), (currentMethod, originalInstance, arg) -> {
            Object ret;
            try {
                ret = currentMethod.invoke(originalInstance, args);
                return ret + " intercept 1";
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
            return " failed! ";
        });
        System.out.println(fee.hello());
    }
}
