package com.bmss.test.dubbo.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by fengxuan1 on 2016/10/19.
 */
public class MergeK {
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        ListNode result2 = new ListNode(0);
        ListNode result = result2;
        List<Integer> templist = new ArrayList<>();
        for(int i = 0; i < lists.length; i++){
            ListNode temp = lists[i];
            while(temp != null){
                System.out.println("========" + temp.val);
                templist.add(temp.val);
                temp = temp.next;
            }
        }
        Collections.sort(templist);
        System.out.println("===list===" + JSON.toJSONString(templist));
        for(int i : templist){
            result2.next = new ListNode(i);
            result2 = result2.next;
        }
        return result.next;
    }


    public static void main(String[] args) {
        /*ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        ListNode b = new ListNode(10);
        ListNode c = new ListNode(100);
        ListNode d = new ListNode(1000);*/
        ListNode a = null;
        ListNode[] m = new ListNode[] {a};
        ListNode node = mergeKLists(m);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}

