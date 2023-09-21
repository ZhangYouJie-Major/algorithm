package com.zhangyoujie;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/9/18
 */
public class Sep_18st {

    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{-1, 2, 9}, 2));
    }


    public static int subarraysDivByK(int[] nums, int k) {
        int length = nums.length;
        int ans = 0;
        int sum = 0;

        Map<Integer, Integer> sumMap = new HashMap<>(1000);
        sumMap.put(0, 1);
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            int mod = (sum % k + k) % k;
            Integer count = sumMap.getOrDefault(mod, 0);
            ans += count;
            sumMap.put(mod, count + 1);
        }

        return ans;

    }

    public int minCount(int[] coins) {
        int ans = 0;
        int length = coins.length;
        for (int i = 0; i < length; i++) {
            if (coins[i] % 2 == 0) {
                ans += coins[i] / 2;
            } else {
                ans += coins[i] / 2 + 1;
            }
        }
        return ans;


    }

    public static int minNumber(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (nums2[j] == nums1[i]) {
                    min = Math.min(min, nums1[i]);
                }
            }
        }
        if (min != 0) {
            return min;
        }


        int min1 = Arrays.stream(nums1).min().getAsInt();
        int min2 = Arrays.stream(nums2).min().getAsInt();

        if (min1 < min2) {
            return min1 * 10 + min2;
        } else if (min1 > min2) {
            return min2 * 10 + min1;
        } else {
            return min1;
        }


    }

//    public int rob(TreeNode root) {
//
//    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
