package com.zhangyoujie;

import java.util.Arrays;

/**
 * @author zhangyoujie
 * @date 2023/8/22
 */
public class Aug_22 {


    public static int maxDistToClosest(int[] seats) {
        int length = seats.length;
        int step = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < length; i++) {
            if (seats[i] == 1) {
                break;
            }
            left++;
        }


        return 1;
    }

//    public int sumOfPower(int[] nums) {
//        int length = nums.length;
//        Arrays.sort(nums);
//        //前n个数
//        int[] dp = new int[length];
//        int[] preSum = new int[length + 1];
//
//        int mod = 1000000007;
//
//        dp[0] = (int) (Math.pow(nums[0], nums[0]) * nums[0] % mod);
//        preSum[0] = dp[0];
//
//        for (int i = 1; i < length; i++) {
////            dp[i] = dp[];
//
//        }
//
//
//    }

}
