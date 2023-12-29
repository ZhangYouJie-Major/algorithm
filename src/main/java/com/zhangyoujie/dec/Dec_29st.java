package com.zhangyoujie.dec;

import sun.plugin.WJcovUtil;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/12/29
 */
public class Dec_29st {

    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        return prices[0] + prices[1] > money ? money : money - (prices[0] + prices[1]);
    }

    public static void main(String[] args) {
        addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1);

    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;

        List<List<Integer>>
                ans = new ArrayList<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // 当(i,j)出队的时候 只有(i,j+1)入队
        // 先处理 num[i] 让k个num1 如队列
        for (int i = 0; i < Math.min(m, k); i++) {
            priorityQueue.add(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (!priorityQueue.isEmpty() && ans.size() < k) {
            int[] poll = priorityQueue.poll();
            int p = poll[1];
            int q = poll[2];
            List<Integer> list = new ArrayList<>();
            list.add(nums1[p]);
            list.add(nums2[q]);
            ans.add(list);
            if (q + 1 < n) {
                priorityQueue.add(new int[]{nums1[p] + nums2[q + 1], p, q + 1});
            }
        }

        return ans;

    }


    public static List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        String target = String.valueOf(k);

        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < target.length(); i++) {
            temp.add(Integer.parseInt(String.valueOf(target.charAt(i))));
        }
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();

        for (int i = 0; i < num.length; i++) {
            deque1.push(num[i]);
        }
        for (Integer value : temp) {
            deque2.push(value);
        }
        Deque<Integer> deque3 = new ArrayDeque<>();
        int i = 0;
        while (!deque1.isEmpty() || !deque2.isEmpty()) {
            Integer pop1 = deque1.isEmpty() ? 0 : deque1.pop();
            Integer pop2 = deque2.isEmpty() ? 0 : deque2.pop();

            int value = (pop1 + pop2 + i) % 10;
            i = (pop1 + pop2 + i) / 10;
            deque3.push(value);


        }
        if (i != 0) {
            deque3.push(i);
        }
        while (!deque3.isEmpty()) {
            ans.add(deque3.pop());
        }
        return ans;

    }

    public int findDuplicate(int[] nums) {

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (binarySearch(nums[i], nums) != binarySearch(nums[i] + 1, nums) - 1) {
                return nums[i];
            }
        }
        return -1;

    }

    public static boolean isPerfectSquare(int num) {

        long left = 0;
        long right = num - 1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid >= num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left * left == num;

    }

    public static int[] searchRange(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int a = binarySearch(target, nums);
        int b = binarySearch(target + 1, nums) - 1;
        return a < b ? new int[]{-1, -1} : new int[]{a, b};
    }

    private static int binarySearch(int target, int[] nums) {
        int left = 0;
        int right = nums.length - 1; // 左闭右闭
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int binarySearch1(int target, int[] nums) {
        // 左开右闭
        int left = -1;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid + 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    private static int binarySearch2(int target, int[] nums) {
        // 左闭右开
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int binarySearch3(int target, int[] nums) {
        // 左闭右开
        int left = -1;
        int right = nums.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
