package com.zhangyoujie.aug;

import com.zhangyoujie.tool.ListNode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
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

    public static void main(String[] args) {
        int[] ints = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer count1 = Integer.parseInt(o1.split("_")[1]);
                Integer count2 = Integer.parseInt(o2.split("_")[1]);
                return count2 - count1;
            }
        });
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();


        int[] ans = new int[k];
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        map.forEach((key, value) -> {
            //元素_次数
            queue.offer(key + "_" + value);

        });
        for (int i = 0; i < k; i++) {
            if (!queue.isEmpty()) {
                ans[i] = Integer.parseInt(queue.poll().split("_")[0]);
            }
        }
        return ans;
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


}
