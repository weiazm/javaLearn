/**
 * Baijiahulian.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.hongyan.learn.concurrentTest;

import com.hongyan.learn.concurrent.PrintNums;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @title PrintNumsThreadPoolTest
 * @desc 线程池技术
 * @author hongyan
 * @date 2016年7月27日
 * @version version
 */
public class PrintNumsThreadPoolTest {
    public static void main(String[] args) {
        PrintNums pn1 = new PrintNums(1, 100, 50);
        PrintNums pn2 = new PrintNums(1, 100, 50);
        PrintNums pn3 = new PrintNums(1, 100, 50);
        PrintNums pn4 = new PrintNums(1000, 1100, 50);
        PrintNums pn5 = new PrintNums(1000, 1100, 50);
        ExecutorService tpe = Executors.newFixedThreadPool(3);
        tpe.submit(pn1);
        tpe.submit(pn2);
        tpe.submit(pn3);
        tpe.submit(pn4);
        tpe.submit(pn5);
        tpe.shutdown();
        // new Thread(pn1, "a").start();
        // new Thread(pn1, "b").start();
        // new Thread(pn1, "c").start();
    }
}
