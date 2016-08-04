/**
 * Baijiahulian.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.hongyan.learn.proxy.universalProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @title ProxyTest
 * @desc description
 * @author hongyan
 * @date 2016年8月4日
 * @version version
 */
public class ProxyTest {

    public static void main(String[] args) {

        UniversalHandler handler = new UniversalHandler(new ArrayList<Integer>(), new BeforeAfter() {
            @Override
            public void before(Object o, Method method, Object[] args) {
                System.out.println("before");
            }
            @Override
            public void after(Object o, Method method, Object[] args) {
                System.out.println("after");
            }
        });

        @SuppressWarnings("unchecked")
        List<Integer> list = (List<Integer>) handler.getProxy();

        list.add(1);
        System.out.println(list);

    }

}
