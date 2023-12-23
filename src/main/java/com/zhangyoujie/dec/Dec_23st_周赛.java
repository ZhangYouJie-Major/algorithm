package com.zhangyoujie.dec;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Dec_23st_周赛 {

    public static void main(String[] args) {
        // 17876942274
        // 1000000000
        // 2144086050
        // 1000000000
        System.out.println(largestPerimeter(new int[]{5,5,50}));
    }


    public static long largestPerimeter(int[] nums) {
        long max = -1;
        int length = nums.length;
        Arrays.sort(nums);

        long[] sum = new long[length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        if (length == 3) {
            max = nums[0] + nums[1] > nums[2] ? sum[length] : -1;
        }
        for (int i = length - 1; i >= 2; i--) {
            long l = nums[i];
            long m = sum[i] - sum[0];
            if (m > l) {
                max = Math.max(max, l + m);
            }
        }
        return max;
    }

    public static int incremovableSubarrayCount(int[] nums) {
        int length = nums.length;
        int sum = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                //
                for (int k = 0; k < i; k++) {
                    if (deque.isEmpty() || deque.peek() < nums[k]) {
                        deque.push(nums[k]);
                    }
                }
                for (int k = j + 1; k < length; k++) {
                    if (deque.isEmpty() || deque.peek() < nums[k]) {
                        deque.push(nums[k]);
                    }
                }
                if (deque.size() == length - (j - i + 1)) {
                    sum++;
                }
                deque.clear();
            }
        }
        return sum;

    }
}
