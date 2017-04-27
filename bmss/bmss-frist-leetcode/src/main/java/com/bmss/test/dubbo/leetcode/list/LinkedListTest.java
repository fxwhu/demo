package com.bmss.test.dubbo.leetcode.list;

import com.alibaba.fastjson.JSON;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;


/**
 * Created by fengxuan1 on 2016/10/20.
 */
/*
* linkedlist可以作为栈使用，符合后进先出，主要需要关注的方法push，pop，peek
*add加到队列尾
*
*
*
* Collections 常用的方法sort 排序 ， reverse 反转，frequery 查找出现次数， max min
* indexOfSubList第一次包含list的位置，swap交换位置 fill
* */
public class LinkedListTest {

    public static void main(String[] args) {
//        Set<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);


        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.push("test");
        linkedList.push("test1");
        linkedList.push("test2");
        linkedList.push("test3");
        linkedList.push("test4");
        linkedList.add("test5");
        System.out.println("max: " + Collections.max(linkedList));
        System.out.println(JSON.toJSONString(linkedList));
        System.out.println(linkedList.peek());
        System.out.println(linkedList.getFirst());
        Collections.reverse(linkedList);
        System.out.println(JSON.toJSONString(linkedList));
    }



}
