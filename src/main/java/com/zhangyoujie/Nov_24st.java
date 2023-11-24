package com.zhangyoujie;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangyoujie
 * @date 2023/11/24
 */
public class Nov_24st {

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));
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


    public static int lengthOfLIS(int[] nums) {

        int length = nums.length;
        // dp[i] 是以i结尾 递增子序列的长度 dp[i] = Math.max(dp[j]+1) 0 < j < i && num[i] > num[j]
        int[] dp = new int[length];
        dp[0] = 1;
        int max = Integer.MIN_VALUE;
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
