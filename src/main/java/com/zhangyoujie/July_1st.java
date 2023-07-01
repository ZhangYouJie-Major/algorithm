package com.zhangyoujie;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/7/1
 */
public class July_1st {

    public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {

        List<Integer> list0 = new ArrayList<>(colsum.length);
        List<Integer> list1 = new ArrayList<>(colsum.length);

        int count = 0;

        for (int i = 0; i < colsum.length; i++) {
            count += colsum[i];
            list0.add(i, 0);
            list1.add(i, 0);
        }

        if (count != upper + lower) {
            return new ArrayList<>();
        }


        List<List<Integer>> result = new ArrayList<>();
        result.add(0, list0);
        result.add(1, list1);

        for (int i = 0; i < colsum.length; i++) {

            if (colsum[i] == 2) {

                upper--;
                lower--;
                List<Integer> upperList = result.get(0);
                List<Integer> lowerList = result.get(1);

                upperList.set(i, 1);
                lowerList.set(i, 1);
                result.set(0, upperList);
                result.set(1, lowerList);
            }
        }

        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 1) {

                if (upper > 0) {
                    List<Integer> upperList = result.get(0);
                    upperList.set(i, 1);
                    upper--;
                    continue;
                }

                if (lower > 0) {
                    List<Integer> lowerList = result.get(1);
                    lowerList.set(i, 1);
                    lower--;
                }
            }
        }

        if (upper != 0 || lower != 0) {
            return new ArrayList<>();
        }


        return result;
    }


    public boolean isCircularSentence(String sentence) {

        String[] s = sentence.split(" ");

        if (s.length == 1) {
            return s[0].charAt(0) == s[0].charAt(s[0].length() - 1);
        }

        if (s[0].charAt(0) != s[s.length - 1].charAt(s[s.length - 1].length() - 1)) {
            return false;
        }

        for (int i = 0; i < s.length - 1; i++) {
            if (s[i].charAt(s[i].length() - 1) != s[i + 1].charAt(0)) {
                return false;
            }

        }
        return true;
    }


    /**
     * 两数之和
     *
     * @param nums   数组
     * @param target 目标值
     * @return 数组
     * <p>
     * 通过哈希表来解决 时间复杂度O(n) 空间复杂度O(n)
     * 将target 减去数组中的每个元素，然后将结果作为key，数组下标作为value存入哈希表中
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(target - nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i) {
                return new int[]{i, map.get(nums[i])};
            }
        }
        return new int[]{};

    }

    /**
     * 删除链表的倒数第 N 个结点
     *
     * @param head 头结点
     * @param n    倒数第n个
     * @return 头结点
     * <p>
     * 通过快慢指针来解决 时间复杂度O(n) 空间复杂度O(1)
     * 1.快指针先走n步
     * 2.快慢指针同时走，当快指针走到尾部时，慢指针刚好走到倒数第n个节点
     * 3.删除倒数第n个节点
     */

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        while (n > 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null) {
            return head.next;
        }

        while (fast.next != null && slow.next != null) {
            fast = fast.next;
            slow = slow.next;

        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        } else {
            head = head.next;
        }
        return head;

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
