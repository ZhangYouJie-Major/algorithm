package com.zhangyoujie;

import java.util.Arrays;

/**
 * @author zhangyoujie
 * @date 2023/10/11
 */
public class Oct_11st {

    public static void main(String[] args) {
        System.out.println(sumDistance(new int[]{-2, 0, 2}, "RLL", 3));

    }

    public static int sumDistance(int[] nums, String s, int d) {
        int length = nums.length;
        long[] temp = new long[length];

        int mod = 1000000007;
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i] + (s.charAt(i) == 'R' ? d : -d);
        }

        Arrays.sort(temp);

        // sum[i]距离总和为 num[i] - num[i-1] + num[i] - num[i-2] +...+ num[i] - num[0] = i * num[i] - (num[0]+...num[i-1])
        long sum = 0;
        long ans = 0;
        for (int i = 0; i < temp.length; i++) {
            ans = (ans + i * temp[i] - sum) % mod;
            sum += temp[i];
        }
        return (int) ans;


    }
}
