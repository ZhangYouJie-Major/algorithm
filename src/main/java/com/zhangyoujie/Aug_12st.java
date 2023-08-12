package com.zhangyoujie;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhangyoujie
 * @date 2023/8/12
 */
public class Aug_12st {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (null == list1 && null == list2) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        if (null != list1) {
            queue.offer(list1);
        }
        if (null != list2) {
            queue.offer(list2);
        }

        ListNode header = new ListNode();
        ListNode tail = header;

        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            tail.next = minNode;
            tail = tail.next;
            if (null != minNode.next) {
                queue.offer(minNode.next);
            }
        }
        return header.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        //使用优先队列 优先队列默认是小顶堆 反转比较器 变成大顶堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode list : lists) {
            if (null != list) {
                queue.offer(list);
            }
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        while (!queue.isEmpty()) {
            ListNode midNode = queue.peek();
            tail.next = midNode;
            tail = tail.next;
            if (null != midNode.next) {
                queue.offer(midNode.next);
            }
        }
        return head.next;

    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            queue.offer(nums[i]);
        }
        for (int i = 1; i <= k; i++) {
            if (i == k && !queue.isEmpty()) {
                return queue.poll();
            }
            queue.poll();
        }
        return 0;


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
