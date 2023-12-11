package com.zhangyoujie.dec;

import java.util.*;


public class Dec_9st {

    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 3, 2, 3, 3}, 2));
    }

    public static long countSubarrays(int[] nums, int k) {
        /**
         * 固定滑动窗口+乘法原理  我们记录下所有的最大值的节点 pos[0] = -1为左边界
         * 每一次的窗口对应所有的数组为 (pos[l] - pos[l-1]) * (length -pos[r])
         */
        int max = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            max = Math.max(max, nums[i]);
        }
        int posLength = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == max) {
                posLength++;
            }
        }

        int[] pos = new int[posLength + 1];
        int posIndex = 1;
        pos[0] = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] == max) {
                pos[posIndex] = i;
                posIndex++;
            }
        }
        int l = 1;
        int r = k;
        long res = 0;
        while (r < pos.length) {
            res += (long) (pos[l] - pos[l - 1]) * (length - pos[r]);
            l++;
            r++;
        }
        return res;

    }

    //todo 明天解决
    public static int maxSubarrayLength(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        // 数字 {第一个下标，次数}
        boolean flag = true;
        Map<Integer, Integer> mapTime = new HashMap<>();
        Map<Integer, Deque<Integer>> mapIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (mapTime.containsKey(nums[i])) {
                Integer time = mapTime.get(nums[i]);
                Deque<Integer> deque = mapIndex.get(nums[i]);
                deque.addFirst(i);

                if (time >= k) {
                    max = Math.max(max, i - left - 1);
                    Integer index = deque.pollLast();
                    left = index > left ? index : left;
                    mapTime.put(nums[i], time);
                } else {
                    max = Math.max(max, i - left + 1);
                    time++;
                    deque.addFirst(i);
                    mapIndex.put(nums[i], deque);
                    mapTime.put(nums[i], time);
                }
            } else {
                max = Math.max(max, i - left + 1);
                mapTime.put(nums[i], 1);
                Deque<Integer> deque = new ArrayDeque<>();
                deque.addFirst(i);
                mapIndex.put(nums[i], deque);
            }
        }
        return max == Integer.MIN_VALUE ? nums.length : max;
    }

    public static int[] findIntersectionValues(int[] nums1, int[] nums2) {

        int ans1 = 0;
        int ans2 = 0;

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        for (int num : nums1) {
            if (map2.containsKey(num)) {
                ans1++;
            }
        }
        for (int num : nums2) {
            if (map1.containsKey(num)) {
                ans2++;
            }
        }
        return new int[]{ans1, ans2};

    }

    public static String tictactoe(int[][] moves) {
        if (moves.length < 5) {
            return "Pending";
        }

        int[][] targets = new int[3][3];

        //假设玩家A是1  B为-1
        int target = 1;
        for (int[] move : moves) {
            targets[move[0]][move[1]] = target;
            target = -target;
            int scan = scan(targets);
            switch (scan) {
                case 3:
                    return "A";
                case -3:
                    return "B";
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }

    public static int scan(int[][] targets) {
        int sum;
        for (int i = 0; i < 3; i++) {
            sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += targets[i][j];
                if (sum == 3 || sum == -3) {
                    return sum;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += targets[j][i];
                if (sum == 3 || sum == -3) {
                    return sum;
                }
            }
        }
        sum = 0;
        if (targets[0][0] + targets[1][1] + targets[2][2] == 3 || targets[0][0] + targets[1][1] + targets[2][2] == -3) {
            sum = targets[0][0] + targets[1][1] + targets[2][2];
        }
        if (targets[0][2] + targets[1][1] + targets[2][0] == 3 || targets[0][2] + targets[1][1] + targets[2][0] == -3) {
            sum = targets[0][2] + targets[1][1] + targets[2][0];
        }

        return sum;
    }
}
