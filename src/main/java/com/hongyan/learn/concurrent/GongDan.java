/**
 * Baijiahulian.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.hongyan.learn.concurrent;

/**
 * @title GongDan
 * @desc description
 * @author hongyan
 * @date 2016年8月1日
 * @version version
 */
public class GongDan {
    private Integer work;
    private Integer end;

    public GongDan(Integer work, Integer end) {
        this.work = work;
        this.end = end;
    }
    
    public synchronized void process(Integer mod) {
        while (work < end) {
        this.proces(mod);
        }
    }

    private void proces(Integer mod) {
        if (work % 3 != mod) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            System.out.println(Thread.currentThread().getName() + ": " + work % 3 + "->" + work);
        work++;
            this.notifyAll();
        }
    }
}
