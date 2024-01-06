package com.zhangyoujie.jan;

import com.zhangyoujie.tool.ListNode;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2024/1/3
 */
public class Jan_1st {


    public static void main(String[] args) {
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(1);
//        ListNode listNode3 = new ListNode(1);
//        ListNode listNode4 = new ListNode(1);
//        ListNode listNode5 = new ListNode(1);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        removeNodes(listNode1);
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] > k) {
                right--;
            } else if (array[left] + array[right] < k) {
                left++;
            } else {
                return true;
            }

        }

        return false;
    }

    private void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);

    }

    public static int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {

        int ans = -1;
        int wait = 0;
        int index = 0;
        int max = 0;
        int temp = 0;
        while (wait > 0 || index < customers.length) {
            wait += index < customers.length ? customers[index] : 0;

            int up = Math.min(4, wait);
            wait -= up;
            temp += up * boardingCost - runningCost;
            index++;
            if (temp > max) {
                max = temp;
                ans = index;
            }
        }

        return ans;

    }


    public static ListNode removeNodes(ListNode head) {
        Deque<Integer> deque = new ArrayDeque<>();


        ListNode tail = head;
        while (null != tail) {
            while (!deque.isEmpty() && deque.peek() < tail.val) {
                deque.pop();
            }
            deque.push(tail.val);
            tail = tail.next;
        }

        ListNode header = new ListNode();
        ListNode tailer = header;

        while (!deque.isEmpty()) {
            ListNode node = new ListNode(deque.pollLast());
            tailer.next = node;
            tailer = tailer.next;
        }

        return header.next;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
