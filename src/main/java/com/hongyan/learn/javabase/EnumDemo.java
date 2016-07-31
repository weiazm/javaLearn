/**
 * Baijiahulian.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.hongyan.learn.javabase;

/**
 * @title EnumDemo
 * @desc description
 * @author hongyan
 * @date 2016年7月27日
 * @version version
 */
public enum EnumDemo {
    HONGYAN(1, "hongyan"), RANGE(2, "range"), CHAOFAN(3, "chaofan"), XIONGER(4, "xionger"), TIANFENG(5, "tianfeng"),;
    private Integer index;
    private String name;

    // 注意private
    private EnumDemo(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 注意static
    public static String getNameFromIndex(Integer index) {
        if (null == index) {
            return null;
        }
        for (EnumDemo ed : EnumDemo.values()) {
            if (index.equals(ed.getIndex())) {
                return ed.getName();
            }
        }
        return null;
    }

    public static EnumDemo getEnumDemoFromIndex(Integer index) {
        if (null == index) {
            return null;
        }
        for (EnumDemo ed : EnumDemo.values()) {
            if (index.equals(ed.getIndex())) {
                return ed;
            }
        }
        return null;
    }

}
