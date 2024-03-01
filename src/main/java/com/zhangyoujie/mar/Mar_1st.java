package com.zhangyoujie.mar;

/**
 * @author zhangyoujie
 * @date 2024/3/1
 */
public class Mar_1st {


    private int[][] memo;

    public boolean validPartition(int[] nums) {
        int length = nums.length;
        boolean[] dp = new boolean[length + 1];
        // dp[i]表示前i个元素是否能有效划分
        // 1、nums[i-1] = nums[i] 则dp[i-1]= ture
        // 2、nums[i-1] = nums[i] = nums[i-2] 则dp[i-1]= ture
        // 3、nums[i-1] +1 = nums[i-2] + 2 = nums[i] 则dp[i-2]= ture
        dp[0] = true;
        for (int i = 1; i < length; i++) {
            if (dp[i - 1] && nums[i] == nums[i - 1] ||
                    i > 1 && dp[i - 2] && (
                            nums[i] == nums[i - 1] && nums[i] == nums[i - 2] ||
                                    nums[i] == nums[i - 1] + 1 && nums[i] == nums[i - 2] + 2
                    )
            ) {
                dp[i + 1] = true;
            }
        }
        return dp[length];

    }


}
