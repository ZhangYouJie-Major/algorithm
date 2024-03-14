package com.zhangyoujie.mar;

/**
 * @author zhangyoujie
 * @date 2024/3/14
 */
public class Mar_14st {

    public long maxArrayValue(int[] nums) {
        int length = nums.length;
        long sum = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            sum = nums[i] <= sum ? nums[i] + sum : nums[i];
        }
        return sum;

    }
}
