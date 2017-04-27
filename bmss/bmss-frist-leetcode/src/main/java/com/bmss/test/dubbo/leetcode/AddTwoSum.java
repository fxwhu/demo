package com.bmss.test.dubbo.leetcode;

/**
 * Created by fengxuan1 on 2016/10/18.
 */
public class AddTwoSum {


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int len1 = 0;
        int len2 = 0;

        ListNode head = l1;

        while (head != null) {
            ++len1;
            head = head.next;
        }

        head = l2;

        while (head != null) {
            ++len2;
            head = head.next;
        }

        ListNode longer = len1 >= len2 ? l1 : l2;
        ListNode shorter = len1 < len2 ? l1 : l2;

        ListNode result = null;
        ListNode sum = null;

        int val = 0;
        int carry = 0;

        while (shorter != null) {
            val = longer.val + shorter.val + carry;
            carry = val / 10;
            val -= carry * 10;

            if (sum == null) {
                sum = new ListNode(val);
                result = sum;
            } else {
                sum.next = new ListNode(val);
                sum = sum.next;
            }


            ListNode resultNode = result;
            while(resultNode != null){
                System.out.println(resultNode.val);
                resultNode = resultNode.next;
            }

            longer = longer.next;
            shorter = shorter.next;
        }

        while (longer != null) {
            val = longer.val + carry;
            carry = val / 10;
            val -= carry * 10;

            sum.next = new ListNode(val);
            sum = sum.next;

            longer = longer.next;
        }

        if (carry != 0) {
            sum.next = new ListNode(carry);
        }

        return result;
    }


    public static ListNode addTwoNodeList2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = l1, q = l2, curr = result;
        int carry = 0;
        while(p != null && q != null){
            int i = (p != null) ? p.val : 0;
            int j = (q != null) ? q.val : 0;
            int sum = i + j + carry;
            carry = sum / 10;
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



    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);


        ListNode result = addTwoNodeList2(l1, l2);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}




