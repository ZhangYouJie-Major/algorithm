package com.zhangyoujie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyoujie
 * @date 2023/7/20
 */
public class July_20st {

    public static void main(String[] args) {


        boolean maxLength = checkSubarraySum(new int[]{0, 1, 0, 3, 0, 4, 0, 4, 0}, 5);
        System.out.println(maxLength);
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        // sum[x] = x * k + mod
        // sum[y] = y * k + mod then sum[y]-sum[x] = (y-x) * k   y-x即为整数n 切y-x>=2
        // 因此我们只需要找前缀和是同余的数即可  考虑边界情况 整数n可能是0 即余数为0的情况

        int length = nums.length;

        if (length < 2) {
            return false;
        }

        int[] sum = new int[length + 1];
        sum[0] = 0;
        for (int i = 0; i < length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        Map<Integer, Integer> index = new HashMap<>();
        index.put(0, -1);
        //sum[j] - sum[i-1] =  a[i] + a[i+1] *** a[j]
        for (int i = 1; i < sum.length; i++) {
            int mod = sum[i] % k;
            if (index.containsKey(mod)) {
                if (i - 1 - index.get(mod) >= 2) {
                    return true;
                }
            } else {
                index.put(mod, i - 1);
            }
        }

        return false;

    }

    public static int findMaxLength(int[] nums) {
        int length = nums.length;
        int[] sum = new int[length];

        //记录每个sum 第一次出现的元素的下标 便于计算最大的长度
        Map<Integer, Integer> res = new HashMap<>();

        int ans = 0;

        sum[0] = nums[0] == 0 ? -1 : nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
            sum[i] = sum[i - 1] + nums[i];
        }

        for (int i = 0; i < sum.length; i++) {
            if (sum[i] == 0) {
                ans = i + 1;
            } else {
                if (res.containsKey(sum[i])) {
                    ans = Math.max(ans, i - res.get(sum[i]));
                } else {
                    res.put(sum[i], i);
                }
            }

        }

        return ans;
    }
}
