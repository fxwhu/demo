package com.bmss.test.dubbo;

/**
 * Created by fengxuan1 on 2016/10/18.
 */
public class TestAddTwoSum {

    public static ListNode addTwoNodeList(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int l1Len = 0;
        int l2len = 0;
        ListNode l1Copy = l1;
        ListNode l2Copy = l2;

        while (l1Copy.next != null){
            l1Len ++;
            l1Copy = l1Copy.next;
        }
        while (l2Copy.next != null){
            l2len ++;
            l2Copy = l2Copy.next;
        }

        ListNode shortList = l1Len < l2len ? l1 : l2;
        ListNode longList = l1Len >= l2len ? l1 :l2;


        ListNode result = null;
        ListNode sum = null;
        int carry = 0;
        int val = 0;
        while (shortList != null){
            val = shortList.val + longList.val + carry;
            carry = val / 10;
            val -= carry * 10;
            if(sum == null) {
                sum = new ListNode(val);
                result = sum;
            }else {
                sum.next = new ListNode(val);
                sum = sum.next;
            }
            shortList = shortList.next;
            longList = longList.next;
        }

        while(longList != null){
            val = longList.val + carry;
            carry = val / 10;
            val -= carry * 10;

            sum.next = new ListNode(val);
            sum = sum.next;

            longList = longList.next;
        }
        if(carry != 0) {
            sum.next = new ListNode(carry);
        }

        return  result;
    }


    public static void main(String[] args) {

    }


    public ListNode addTwoNodeList2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = l1, q = l2, curr = result;
        int carry = 0;
        while(p != null && q != null){
            int i = (p != null) ? p.val : 0;
            int j = (q != null)? q.val : 0;
            int sum = i + j + carry;
            carry = carry / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null)
                p = p.next;
            if(q != null)
                q = q.next;
        }
        if(carry != 0) {
            result.next = new ListNode(carry);
        }
        return result.next;
    }



}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
