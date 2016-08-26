/**
 * Baijiahulian.com Inc.
 * Copyright (c) 2014-2016 All Rights Reserved.
 */
package com.hongyan.learn.javabaseTest;

import com.hongyan.learn.catalog.javabase.HyMark;
import com.hongyan.learn.catalog.javabase.HyMarkBean;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @title HyMarkBeanTest
 * @desc description
 * @author hongyan
 * @date 2016年7月27日
 * @version version
 */
public class HyMarkBeanTest {
    @Test
    public void test() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException,
        IllegalArgumentException, InvocationTargetException, InstantiationException {
        /**
         * 反射访问方法
         */
        Class<?> hyMarkBean = Class.forName("com.hongyan.javabase.HyMarkBean");
        System.out.println("获得class成功：" + hyMarkBean.getName());
        Method[] methods = hyMarkBean.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        /**
         * 反射调用方法
         */
        HyMarkBean hmb = (HyMarkBean) hyMarkBean.newInstance();
        Method method = hyMarkBean.getDeclaredMethod("fuck");
        // 通过setAccessible设置私有方法可访问
        method.setAccessible(true);
        System.out.println(method.invoke(hmb));
        /**
         * 反射访问域的注解
         */
        // getFields得到公有字段
        Field[] fields = hyMarkBean.getFields();
        // getDeclaredFields得到所有字段
        fields = hyMarkBean.getDeclaredFields();
        System.out.println();
        for (Field field : fields) {
            Annotation anno = field.getAnnotation(HyMark.class);
            System.out.println(anno);
        }
        /**
         * 按照注解的num排序fields
         */
        List<Field> list = Arrays.asList(fields);
        System.out.println(list);
        Collections.sort(list, new Comparator<Field>() {
            @Override
            // 相减的顺序与参数顺序一致 递增
            public int compare(Field o1, Field o2) {
                return o1.getAnnotation(HyMark.class).num() - o2.getAnnotation(HyMark.class).num();
            }
        });
        System.out.println(list);

    }
}
