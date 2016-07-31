/**
 * Baijiahulian.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.hongyan.learn.concurrent.cdsn.one;

import lombok.Data;

/**
 * @title Count
 * @desc description
 * @author hongyan
 * @date 2016年7月31日
 * @version version
 */
@Data
public class Count {
    private int num;
    private Integer start;
    private Integer end;
    
    public Count(Integer start, Integer end){
        this.start = start;
        this.end = end;
    }

    public void count() {
        for (int i = start; i < end; i++) {
            num+=i;
        }
        System.out.println(Thread.currentThread().getName() + "-" + num);
    }
}
