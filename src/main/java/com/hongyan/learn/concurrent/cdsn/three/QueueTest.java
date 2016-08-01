/**
 * Baijiahulian.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.hongyan.learn.concurrent.cdsn.three;

/**
 * @title QueueTest
 * @desc description
 * @author hongyan
 * @date 2016年7月31日
 * @version version
 */
public class QueueTest {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        final MyBlockingQueue<Integer> queue = new MyBlockingQueue<Integer>(9);

        class Producer implements Runnable {
            @Override
            public void run() {
                try {
                    Thread.sleep(11);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                    queue.put(1);
            }
        }

        class Consumer implements Runnable {
            @Override
            public void run() {
                try {
                    Thread.sleep(12);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                    queue.get();
            }
        }

        for (int i = 0; i < 1000; i++) {
            new Thread(new Consumer()).start();
            new Thread(new Producer()).start();
        }
        Thread.sleep(100);
        System.out.println(queue.box.size());
    }

}
