package com.zhangyoujie.dec;

import java.sql.SQLOutput;
import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/12/22
 */
public class Dec_22st {

    public static void main(String[] args) {
        findOcurrences("alice is a good girl she is a good student", "a", "good");
    }


    public static String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
        String[] split = text.split(" ");
        for (int i = 0; i < split.length - 2; i++) {
            if (Objects.equals(split[i], first) && Objects.equals(split[i + 1], second)) {
                list.add(split[i + 2]);
            }
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;

    }

    public static int respace(String[] dictionary, String sentence) {

        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int length = sentence.length();
        int[] dp = new int[length + 1];
        //dp[i] 表示前i个字符中最少的匹配数
        for (int i = 1; i <= length; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                // 如果 字符串的(j,i) 包含在字典中 则 dp[i] = Math.min(dp[j],dp[i])
                if (set.contains(sentence.substring(j, i)))
                    dp[i] = Math.min(dp[i], dp[j]);
            }
        }

        return dp[length];
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
