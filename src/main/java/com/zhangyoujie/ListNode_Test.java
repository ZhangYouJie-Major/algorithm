package com.zhangyoujie;

import sun.plugin.WJcovUtil;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/8/12
 */
public class ListNode_Test {

    public static void main(String[] args) {


//        int rob = rob(new int[]{2,3,2});
//        System.out.println(rob);
//        Integer i = maxSizeSlices(new int[]{1, 2, 3, 4, 5, 6});
//        System.out.println(i);
//
//        //[3,4,5,4,2,5,5,9,9,9]
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(5);
        ListNode listNode8 = new ListNode(9);
        ListNode listNode9 = new ListNode(9);
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


        ListNode listNode = revert1(listNode1);
        while (null != listNode) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (null != fast && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    public static int rob(int[] nums) {
        int length = nums.length;
        //dp[0][i]代表不偷第一家  dp[1][i]代表不偷第一家
        int dp[][] = new int[2][length];
        //dp[i]表示前i间房屋的最大金额
        dp[0][0] = 0;
        dp[1][0] = nums[0];

        if (length == 1) {
            return dp[1][0];
        }
        dp[0][1] = nums[1];
        dp[1][1] = nums[0];

        for (int i = 2; i < length; i++) {
            if (i == length - 1) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2] + nums[i]);
                dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 1]);
            } else {
                dp[0][i] = Math.max(dp[0][i - 1], dp[0][i - 2] + nums[i]);
                dp[1][i] = Math.max(dp[1][i - 1], dp[1][i - 2] + nums[i]);
            }

        }
        return Math.max(dp[0][length - 1], dp[1][length - 1]);

    }

    public static ListNode revert1(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode last = head;
        ListNode curr = head.next;
        ListNode temp;
        while (null != curr) {
            temp = curr;
            curr = curr.next;
            temp.next = head;
            head = temp;
        }
        last.next = null;
        return head;


    }

    public static ListNode revert(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode pre = null;
        ListNode curr = head;
        ListNode currNext = null;
        ListNode newHeader = null;
        while (null != curr) {
            currNext = curr.next;
            if (null == currNext) {
                newHeader = pre;
            }
            curr.next = pre;
            pre = curr;
            curr = currNext;

        }
        return newHeader;

    }

    public static int maxSizeSlices(int[] slices) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        //通过slices 构建一个环形链表
        int length = slices.length;
        ListNode header = new ListNode();
        ListNode tail = header;
        for (int i = 0; i < length; i++) {
            priorityQueue.offer(slices[i]);
            ListNode node = new ListNode(slices[i]);
            tail.next = node;
            tail = tail.next;
        }
        tail.next = header.next;
        int sum = 0;
        ListNode left = header;
        ListNode curr = left.next;
        ListNode right = curr.next;
        while (null != left) {
            if (priorityQueue.peek() == curr.val) {
                sum += priorityQueue.poll();
                priorityQueue.remove(left.val);
                priorityQueue.remove(right.val);
            }
            left = right.next;
            curr = left.next;
            right = curr.next;

        }
        return sum;
    }

    public static ListNode swapPairs(ListNode head) {
        //偶数
        Deque<Integer> deque1 = new ArrayDeque<>();
        //奇数
        Deque<Integer> deque2 = new ArrayDeque<>();
        int intdex = 0;

        ListNode ans = new ListNode();
        ListNode tail = ans;
        while (null != head) {
            if (intdex % 2 == 0) {
                deque1.addFirst(head.val);
            } else {
                deque2.addFirst(head.val);
            }
            head = head.next;
            intdex++;
        }
        intdex = 0;
        while (!deque1.isEmpty() || !deque2.isEmpty()) {
            int value = 0;
            if (intdex % 2 == 0) {
                if (deque2.isEmpty()) {
                    value = deque1.pollLast();
                } else {
                    value = deque2.pollLast();
                }

            } else {
                if (deque1.isEmpty()) {
                    value = deque2.pollLast();
                } else {
                    value = deque1.pollLast();
                }

            }
            ListNode node = new ListNode(value);
            tail.next = node;
            tail = node;
            intdex++;
        }
        return ans.next;
    }

    public static ListNode doubleIt(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode last = head;
        ListNode curr = head.next;
        ListNode temp;
        while (null != curr) {
            temp = curr;
            curr = curr.next;
            temp.next = head;
            head = temp;
        }
        last.next = null;


        return head;

    }

    public static class ListNode {
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
