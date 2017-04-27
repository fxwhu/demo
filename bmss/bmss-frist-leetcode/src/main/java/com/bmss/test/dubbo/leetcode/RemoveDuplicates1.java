package com.bmss.test.dubbo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengxuan1 on 2016/10/20.
 */
public class RemoveDuplicates1 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode copy = result;
        List<Integer> list = new ArrayList<>();
        while(head != null){
            int value = head.val;
            if(!list.contains(value)) {
                list.add(value);
            }
            head = head.next;
        }
        for(int i : list){
            copy.next = new ListNode(i);
            copy = copy.next;
        }
        return result.next;
    }


    public static void main(String[] args) {
    }
}
