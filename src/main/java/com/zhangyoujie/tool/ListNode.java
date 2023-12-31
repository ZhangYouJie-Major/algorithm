package com.zhangyoujie.tool;

import com.zhangyoujie.dec.Dec_1st;

/**
 * @author zhangyoujie
 * @date 2023/12/1
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
