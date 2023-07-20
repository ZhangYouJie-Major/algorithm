package com.zhangyoujie;

import java.util.Arrays;

/**
 * @author zhangyoujie
 * @date 2023/7/19
 */
public class July_19st {

    public static void main(String[] args) {
        productExceptSelf(new int[]{-1,1,0,-3,3});
    }


    public static int[] productExceptSelf(int[] nums) {

        /*         优化代码 先计算左边的乘法 然后倒过来计算右边的乘积
         *
         *         int length = nums.length;
         *         int[] ans = new int[length];
         *         int[] L = new int[length];
         *         int[] R = new int[length];
         *         L[0] = nums[0];
         *         R[length - 1] = nums[length - 1];
         *         for (int i = 1; i < length; i++) {
         *             L[i] = L[i - 1] * nums[i];
         *         }
         *         for (int i = length - 2; i >= 0; i--) {
         *             R[i] = R[i + 1] * nums[i];
         *         }
         *         ans[0] = R[1];
         *         ans[length - 1] = L[length - 2];
         *         for (int i = 1; i < length - 1; i++) {
         *             ans[i] = L[i - 1] * R[i + 1];
         *         }
         *         return ans;
         */
        int length = nums.length;

        int[] ans = new int[length];

        int[] L = new int[length];
        int[] R = new int[length];

        //
        L[0] = nums[0];
        R[length - 1] = nums[length - 1];
        for (int i = 1; i < length; i++) {
            L[i] = L[i - 1] * nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i];
        }
        ans[0] = R[1];
        ans[length - 1] = L[length - 2];
        for (int i = 1; i < length - 1; i++) {
            ans[i] = L[i - 1] * R[i + 1];
        }

        return ans;

    }
}
