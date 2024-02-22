package com.zhangyoujie.aug;

import com.zhangyoujie.tool.ListNode;

/**
 * @author zhangyoujie
 * @date 2023/9/27
 */
public class Aug_27st {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(5);
        ListNode listNode8 = new ListNode(9);
        ListNode listNode9 = new ListNode(8);
        ListNode listNode10 = new ListNode(9);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;

        ListNode listNode = removeNthFromEnd(listNode1, 2);
        System.out.println(listNode);
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode tail = head;

        int length = 0;
        while (null != tail) {
            tail = tail.next;
            length++;
        }
        int index = length - n + 1;
        tail = head;
        while (null != tail) {
            if (index == 0 && null != tail.next) {
                tail.next = tail.next.next;
            } else if (index == 0 && null == tail.next) {

            }else {

            }
            index--;
        }

        return head;

    }



}
