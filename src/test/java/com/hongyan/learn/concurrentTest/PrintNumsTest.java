/**
 * Baijiahulian.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.hongyan.learn.concurrentTest;

import com.hongyan.learn.concurrent.PrintHello;
import com.hongyan.learn.concurrent.PrintNums;

/**
 * @title PrintNumsTest
 * @desc description
 * @author hongyan
 * @date 2016年7月27日
 * @version version
 */
public class PrintNumsTest {

    public static void main(String[] args) {
        PrintNums pn1 = new PrintNums(1, 100, 50);
        PrintHello ph = new PrintHello();

        Thread t1 = new Thread(pn1, "a");
        Thread t2 = new Thread(pn1, "b");
        Thread t3 = new Thread(pn1, "c");
        Thread t4 = new Thread(ph, "d");

        // 设置守护线程，当jvm中仅存守护线程时，jvm关闭。
        t4.setDaemon(true);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
