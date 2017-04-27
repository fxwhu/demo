package com.bmss.test.dubbo.leetcode.list;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by fengxuan1 on 2016/10/20.
 */

/*
*
* Collections 常用的方法sort 排序 ， reverse 反转，frequery 查找出现次数， max min
* indexOfSubList第一次包含list的位置，swap交换位置 fill替换,shuffle 随机
* */
public class CollectionsTest {

    public static void testFillAndWrap() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 5, 3, 9, 4, 2);
        int local = Collections.indexOfSubList(list, Arrays.asList(2, 5, 3));
        System.out.println(local);

        Collections.swap(list, 0, 3);
        System.out.println(JSON.toJSONString(list));
    }

    public static void main(String[] args) {
        testFillAndWrap();
    }
}
