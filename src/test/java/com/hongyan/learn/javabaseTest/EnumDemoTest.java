/**
 * Baijiahulian.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.hongyan.learn.javabaseTest;

import com.hongyan.learn.javabase.EnumDemo;

import org.junit.Test;

/**
 * @title EnumDemoTest
 * @desc description
 * @author hongyan
 * @date 2016年7月27日
 * @version version
 */
public class EnumDemoTest {

    @Test
    // 注意 public、void、方法无参数。
    public void test() {
        String str = EnumDemo.getNameFromIndex(1);
        String str2 = EnumDemo.CHAOFAN.getName();
        System.out.println(str);
        System.out.println(str2);

        EnumDemo ed = EnumDemo.getEnumDemoFromIndex(3);
        System.out.println(ed);
    }

}
