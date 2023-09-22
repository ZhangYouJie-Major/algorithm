package com.zhangyoujie;

import sun.awt.geom.AreaOp;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/9/18
 */
public class Sep_18st {

    public static void main(String[] args) {

        System.out.println(distMoney(16, 3));

    }

    /**
     * 2591. 将钱分给最多的儿童
     * 贪心算法 优先分给最多的人
     *
     * @param money    钱
     * @param children 儿童
     * @return 最多分给多少个人
     */
    public static int distMoney(int money, int children) {
        if (children > money) {
            return -1;
        }

        money -= children;
        int cnt = Math.min(money / 7, children);
        money -= cnt * 7;
        children -= cnt;
        //如果每个人都分到了 但是还是有剩余的钱 或者 恰好剩余了一个人 但是剩下了3美元  都减去1
        if ((children == 0 && money > 0) || (children > 0 && money == 3)) {
            cnt--;
        }
        return cnt;
    }

    public static int giveGem(int[] gem, int[][] operations) {
        int length = operations.length;
        for (int i = 0; i < length; i++) {
            int fromIndex = operations[i][0];
            int toIndex = operations[i][1];
            int temp = gem[fromIndex] / 2;
            gem[fromIndex] -= temp;
            gem[toIndex] += temp;
        }
        Arrays.sort(gem);
        return gem[gem.length - 1] - gem[0];
    }

    public static int subarraysDivByK(int[] nums, int k) {
        int length = nums.length;
        int ans = 0;
        int sum = 0;

        Map<Integer, Integer> sumMap = new HashMap<>(1000);
        sumMap.put(0, 1);
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            //因为负数取模的时候会出现负数 所以要取模之后再加k 再取模
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
