package com.bmss.test.dubbo.beantest;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by fengxuan1 on 2017/4/24.
 */
public class BeanTestTest {

    @Test
    public void testCopy(){
        People people = new People("test", "male", new Address("beijing"));
        Student student = new Student();
        try {
            BeanUtils.copyProperties(student, people);

            System.out.println("student:" + JSON.toJSONString(student));

            System.out.println("people:" + JSON.toJSONString(people));

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void copyByBeanUtils(){
        People people = new People("test", "male", new Address("beijing"));
        Student student = new Student();
        org.springframework.beans.BeanUtils.copyProperties(people, student);

        System.out.println("student:" + JSON.toJSONString(student));

        System.out.println("people:" + JSON.toJSONString(people));
    }


    @Test
    public void testSet(){
        Set<String> objects = Sets.newConcurrentHashSet();
        objects.add("a");
        objects.add("a");
        objects.add("b");


        ArrayList<String> strings = Lists.newArrayList(objects);
        System.out.println(JSON.toJSONString(strings));



    }


    @Test
    public void testSet2(){

        ArrayList<String> strings = Lists.newArrayList();
        Set<String> objects = Sets.newConcurrentHashSet(strings);


        ArrayList<String> strings1 = Lists.newArrayList(objects);


        strings1.add("1");
        System.out.println(JSON.toJSONString(strings1));



    }

}