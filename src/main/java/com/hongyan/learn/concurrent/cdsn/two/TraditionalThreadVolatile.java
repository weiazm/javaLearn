/**
 * Baijiahulian.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.hongyan.learn.concurrent.cdsn.two;

/**
 * @title TraditionalThreadVolatile
 * @desc description
 * @author hongyan
 * @date 2016年7月31日
 * @version version
 */
public class TraditionalThreadVolatile {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final Test test = new Test();
        new Thread() {
            @Override
            public void run() {
                test.one();
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                test.two();
            }
        }.start();

    }

    static class Test {
        static volatile int i = 0,j=0;

        // 锁在静态方法上,相当于锁住了这个类
        static /* synchronized */ void one() {
            i++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            j++;
        }

        static /* synchronized */ void two() {
            System.out.println(i + ":" + j);
        }
    }

}
