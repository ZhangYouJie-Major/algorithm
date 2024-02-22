package com.zhangyoujie.feb;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhangyoujie
 * @date 2024/2/5
 */
public class Feb_5st {

    public static void main(String[] args) {
        Feb_5st feb5st = new Feb_5st();
        System.out.println(feb5st.maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2));
    }

    public int maxResult(int[] nums, int k) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        // index,dp[j]
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i < length; i++) {

            // 如果小于

            if (deque.peekFirst() < i - k) {

            }

        }
        return dp[length - 1];

        // int length = nums.length;
        // int[] dp = new int[length];
        // dp[0] = nums[0];
        // for (int i = 1; i < length; i++) {
        // int mx = Integer.MIN_VALUE;
        // for (int j = Math.max(i - k, 0); j < i; j++) {
        // mx = Math.max(mx, dp[j]);
        // }
        // dp[i] = mx + nums[i];
        // }
        // return dp[length - 1]
    }

//    private int dfs(int i, int[] memo, int[] nums, int k) {
//        //边界情况
//        if (i == 0) {
//            return nums[0];
//        }
//        if (i >= 0 && memo[i] != 0) {
//            return memo[i];
//        }
//        int mx = Integer.MIN_VALUE;
//        for (int j = Math.max(i - k, 0); j < i; j++) {
//            mx = Math.max(mx, dfs(j, memo, nums, k));
//        }
//        return memo[i] = mx + nums[i];
//    }
}
