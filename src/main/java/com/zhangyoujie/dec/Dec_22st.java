package com.zhangyoujie.dec;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Map;

/**
 * @author zhangyoujie
 * @date 2023/12/22
 */
public class Dec_22st {

    public static void main(String[] args) {
        System.out.println(minimumMountainRemovals(new int[]{1, 2, 1, 3, 4, 4}));
    }


    public static int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];

        int ans = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    public static int minimumMountainRemovals(int[] nums) {
        /*
         * 题目类似 https://leetcode.cn/problems/longest-increasing-subsequence/description/
         *  要求得到最大的山形数组
         *  必须满足下标 i
         *  小于下标i 的数组 我们得到最长的上升子序列 对于大于下标i 的数组 我们得到最长下降子序列
         *  pre[i] = Math.max{pre[i], pre[j]+1 } 0<= j < i  满足 nums[j] < nums[i]
         *  suf[i] = Math.max{pre[i], pre[j]+1 } i <= j < length - 1 满足 nums[j] < nums[i]
         *  max = Math.max{max, suf[i] + pre[i] - 1 }
         *  且满足 suf[i] >= 2 pre[i] >= 2 处理边界情况
         */
        int length = nums.length;
        int max = 0;
        int[] pre = new int[length];
        int[] suf = new int[length];
        Arrays.fill(pre, 1);
        Arrays.fill(suf, 1);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    pre[i] = Math.max(pre[i], pre[j] + 1);
            }
        }
        for (int i = length - 1; i >= 0; i--) {
            for (int j = length - 1; j > i; j--) {
                if (nums[j] < nums[i]) {
                    suf[i] = Math.max(suf[i], suf[j] + 1);
                }

            }
        }
        for (int i = 0; i < length; i++) {
            if (suf[i] == 1 || pre[i] == 1) continue;
            max = Math.max(max, suf[i] + pre[i] - 1);
        }
        return length - max;
    }
}
