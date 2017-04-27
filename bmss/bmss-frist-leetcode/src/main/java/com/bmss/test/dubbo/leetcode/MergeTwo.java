package com.bmss.test.dubbo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by fengxuan1 on 2016/10/19.
 */
public class MergeTwo {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result2 = new ListNode(0);
        ListNode result = result2;
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        List<Integer> list1 = new ArrayList<>();
        while(l1 != null){
            list1.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            list1.add(l2.val);
            l2 = l2.next;
        }
        Collections.sort(list1);
        for(int i : list1){
            result2.next = new ListNode(i);
            result2 = result2.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode result = mergeTwoLists(l1, l2);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
