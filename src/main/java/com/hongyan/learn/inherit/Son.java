/**
 * Baijiahulian.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.hongyan.learn.inherit;

/**
 * @title Son
 * @desc description
 * @author hongyan
 * @date 2016年8月4日
 * @version version
 */
public class Son extends Father {
    @SuppressWarnings("unused")
    private int age = 5;

    static {
        System.out.println("im son's static block!");
    }

    {
        System.out.println("im son's code block!");
    }

    public Son() {
        System.out.println("im son's constructor!");
    }
}
