package com.bmss.test.dubbo.leetcode.list;

import java.util.*;

/**
 * Created by fengxuan1 on 2016/10/20.
 */
public class MapTest {
    public static void main(String[] args) {
        testSysMap();
    }


    public static void testSysMap(){
        for(Map.Entry entry : System.getenv().entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void testMapCount(){
        List<String> list = Arrays.asList("1","2","3","1","4","5");
        Map<String, Integer> map = new HashMap<>();
        for(String s : list) {
            int nums = Collections.frequency(list, s);
            map.put(s, nums);
        }
        System.out.println(map);
    }
}
