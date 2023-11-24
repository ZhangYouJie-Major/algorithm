package com.zhangyoujie;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangyoujie
 * @date 2023/11/24
 */
public class Nov_24st {

    public static void main(String[] args) {
        sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

//    public String removeDuplicateLetters(String s) {
//
//    }

    public static void sortColors(int[] nums) {
        int length = nums.length;

        int left = 0;
        int right = length - 1;
        for (int i = 0; i < length; i++) {
            while (i <= right && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                --right;
            }

            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                ++left;
            }

        }
    }

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            String binaryString = Integer.toBinaryString(i);
            int sum = 0;
            for (int j = 0; j < binaryString.length(); j++) {
                if (binaryString.charAt(j) == '1') {
                    sum++;
                }
            }
            ans[i] = sum;
        }
        return ans;
    }

    public static boolean isPowerOfThree(int n) {
        int max = 2147483647;
        int target = 1;
        for (int i = 0; i < 31; i++) {
            if (target == n) {
                return true;
            }
            target *= 3;
            if (target > max) {
                break;
            }
        }
        return false;
    }

    public static int countPairs(List<Integer> nums, int target) {
        nums = nums.stream().sorted().collect(Collectors.toList());
        int size = nums.size();
        int left = 0;
        int right = left + 1;

        int ans = 0;
        while (right < size) {
            if (nums.get(left) + nums.get(right) < target) {
                ans++;
                right++;
            } else {
                left++;
                right = left + 1;
                continue;
            }
            if (right == size) {
                left++;
                right = left + 1;
            }

        }
        return ans;
    }

    public static int nthSuperUglyNumber(int n, int[] primes) {

        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(1);
        while (n-- > 0) {
            int x = q.poll();
            if (n == 0) return x;
            for (int k : primes) {
                if (k <= Integer.MAX_VALUE / x) q.add(k * x);
                if (x % k == 0) break;
            }
        }
        return -1; // never
    }


    public static int lengthOfLIS(int[] nums) {

        int length = nums.length;
        // dp[i] 是以i结尾 递增子序列的长度 dp[i] = Math.max(dp[j]+1) 0 < j < i && num[i] > num[j]
        int[] dp = new int[length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;

    }
}
