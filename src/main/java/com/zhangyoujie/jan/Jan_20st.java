package com.zhangyoujie.jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zhangyoujie
 * @date 2024/1/20
 */
public class Jan_20st {

    public static void main(String[] args) {
        Jan_20st st = new Jan_20st();
        System.out.println((new int[]{31, 26, 33, 21, 40}));
    }


    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int length = stones.length;
        for (int i = 0; i < length; i++) {
            queue.add(stones[i]);
        }
        while (!queue.isEmpty()) {
            int a = queue.poll();
            if (queue.isEmpty()) return a;
            int b = queue.poll();
            if (a != b) queue.add(Math.abs(a - b));
        }
        return 0;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int length = nums.length;
        int sum = Arrays.stream(nums).sum();
        //  定义添加 -元素之和为neg 加号元素之和 sum - neg sum - 2 * neg = target -> neg  = (sum - target)/2
        // neg > 0  -> (sum - target) > 0 && (sum - target) % 2 == 0
        // dp[i][j] 表示前i个元素 和为j的最大组合  dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]]
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        // 我们要从数组中选出元素 之和等于 neg
        int neg = diff / 2;
        int[][] dp = new int[length + 1][neg + 1];
        // 前0和数字 neg为0的数组是1 neg > 0 的组合没有
        dp[0][0] = 1;
        for (int i = 1; i <= neg; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j] + ((j >= nums[i - 1]) ? dp[i - 1][j - nums[i - 1]] : 0);
            }
        }
        return dp[length][neg];
    }

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            for (String s : word.split("\\" + separator)) {
                if (s.length() > 0) {
                    ans.add(s);
                }
            }
        }
        return ans;
    }

}
