/**
 * Baijiahulian.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.hongyan.learn.concurrentTest;

import com.hongyan.learn.catalog.concurrent.MultithreadProcessor;

import java.io.FileNotFoundException;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @title MultithreadProcessorTest
 * @desc description
 * @author hongyan
 * @date 2016年7月27日
 * @version version
 */
public class MultithreadProcessorTest {

    /**
     * @param args
     * @throws InterruptedException
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        LinkedBlockingQueue<Integer> workQueue = new LinkedBlockingQueue<Integer>();
        for (int i = 1; i < 201; i++) {
            workQueue.offer(i);
        }
        System.out.println(workQueue);

        MultithreadProcessor mp1 = new MultithreadProcessor(workQueue, 0, 50);
        MultithreadProcessor mp2 = new MultithreadProcessor(workQueue, 1, 40);
        MultithreadProcessor mp3 = new MultithreadProcessor(workQueue, 2, 130);

        new Thread(mp1, "mod = 0").start();
        new Thread(mp2, "mod = 1").start();
        new Thread(mp3, "mod = 2").start();

        // FileInputStream bio = new FileInputStream("/Users/in.txt");
        // FileInputStream nio = new FileInputStream("/Users/in.txt");
        // byte[] biobytes = new byte[100];
        // ByteBuffer nioBuffer = ByteBuffer.allocate(100);
        // bio.read(biobytes);
        // nio.getChannel().read(nioBuffer);
        // epoll poll
    }

}
