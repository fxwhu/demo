package com.bmss.test.dubbo.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengxuan1 on 2016/10/20.
 */
public class RemoveNth {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return null;
        ListNode result = new ListNode(0);
        ListNode result2 = result;
        ListNode node2 = head;
        List<Integer> list = new ArrayList<>();
        int size = 0;
        while(node2 != null){
            size ++;
            node2 = node2.next;
        }
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        list.remove(size - n);
        for(int i : list){
            result2.next = new ListNode(i);
            result2 = result2.next;
        }
        return result.next;
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        ListNode node = removeNthFromEnd(a, 2);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
