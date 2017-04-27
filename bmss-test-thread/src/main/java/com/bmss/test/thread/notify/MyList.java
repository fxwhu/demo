package com.bmss.test.thread.notify;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by fengxuan1 on 2017/1/1.
 */
public class MyList {

    private static List<String> list = Lists.newArrayList();

    public static void add(String message){
        list.add(message);
    }

    public static int getSize(){
        return list.size();
    }
}
