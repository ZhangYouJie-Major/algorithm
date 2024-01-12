package com.zhangyoujie.jan;

import java.util.*;

public class Jan_st_双周赛 {

    public static void main(String[] args) {
        System.out.println(minimumOperationsToMakeEqual(26, 1));
    }

    public static int minimumOperationsToMakeEqual(int x, int y) {
        if (x == y) {
            return 0;
        }
        int count = 0;
        int min = Math.min(x, y);
        int max = Math.max(x, y);
        while (min < max) {
            if (min * 11 < max) {
                min *= 11;
                count++;
                continue;
            }
            if (min * 5 < max) {
                min *= 5;
                count++;
                continue;
            }
            min++;
            count++;
        }
        return count;


    }

    public static int minOperations(int[] nums, int k) {
        int length = nums.length;
        int x = 0;
        for (int i = 0; i < length; i++) {
            x ^= nums[i];
        }
        return Integer.bitCount(x ^ k);

        // 0010
        // 0001
        // 0011
        // 0100
        // 0100
        // 0001

    }

    public static int missingInteger(int[] nums) {
        int length = nums.length;
        int sum = 0;
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < length; i++) {
            set.add(nums[i]);
        }
        int start = nums[0];
        for (int i = 0; i < length; i++) {
            if (nums[i] == start) {
                sum += nums[i];
            } else {
                break;
            }
            start++;
        }

        for (int i = sum; i < 10000; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return sum;
    }
}
