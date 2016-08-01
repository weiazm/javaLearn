/**
 * Baijiahulian.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.hongyan.learn.concurrent.cdsn.four;

/**
 * @title YieldTest
 * @desc description
 * @author hongyan
 * @date 2016年8月1日
 * @version version
 */
public class YieldTest {
    public static void main(String[] args) throws InterruptedException {
        // 创建线程对象
        YieldThread t1 = new YieldThread("t1");
        YieldThread t2 = new YieldThread("t2");
        // 启动线程
        t1.start();
        t2.start();
        // 主线程休眠100毫秒
        Thread.sleep(100);
        // 终止线程
        t1.interrupt();
        t2.interrupt();
    }
}

class YieldThread extends Thread {
    int i = 0;

    public YieldThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            System.out.println(getName() + "执行了" + ++i + "次");
            if (i % 10 == 0) {// 当i能对10整除时，则让步
                Thread.yield();// 让步 却不释放锁
            }
        }
    }
}
