package com.zhangyoujie;

/**
 * @author zhangyoujie
 * @date 2023/11/16
 */
public class Nov_16st {

    public static void main(String[] args) {
        // 101010
        System.out.println(Integer.numberOfLeadingZeros(42));
        System.out.println();
        System.out.println(longestAlternatingSubarray(new int[]{2, 2}, 18));
    }

    public static int longestAlternatingSubarray(int[] nums, int threshold) {
        int length = nums.length;

        int[] dp = new int[length];
        //dp[i] 以i结尾的最长交替子数组的长度
        dp[0] = nums[0] > threshold ? 1 : 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < threshold) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 0;
            }
        }
        int ans = 0;
        return ans;

    }
}
