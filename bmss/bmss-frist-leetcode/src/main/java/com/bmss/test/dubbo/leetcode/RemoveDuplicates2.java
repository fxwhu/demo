package com.bmss.test.dubbo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by fengxuan1 on 2016/10/20.
 */
public class RemoveDuplicates2 {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode result = new ListNode(0);
        ListNode copy = result;
        List<Integer> list = new ArrayList<>();
        List<Integer> quencylist = new ArrayList<>();

        while(head != null){
            int value = head.val;
            list.add(value);
            head = head.next;
        }

        for(int i : list) {
            int frequency = Collections.frequency(list, i);
            if(frequency == 1){
                quencylist.add(i);
            }
        }

        for(int i : quencylist){
            copy.next = new ListNode(i);
            copy = copy.next;
        }
        return result.next;
    }



    public static ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                int val = head.next.val;
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }

        return dummy.next;
    }



    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(2);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(2);
        ListNode node = deleteDuplicates2(a);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
