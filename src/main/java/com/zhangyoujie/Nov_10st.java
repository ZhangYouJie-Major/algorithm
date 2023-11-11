package com.zhangyoujie;

import java.util.Arrays;

/**
 * @author zhangyoujie
 * @date 2023/11/10
 */
public class Nov_10st {

    public static void main(String[] args) {
        System.out.println((long) Math.ceil((double) 7 / 5));
        System.out.println((7 + 5 - 1) / 5 - 1);
        int[] ints = successfulPairs(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int sl = spells.length;
        int pl = potions.length;

        int ans[] = new int[sl];
        Arrays.sort(potions);
        for (int i = 0; i < sl; i++) {
            long target = (success + spells[i] - 1) / spells[i] - 1;
            ans[i] = pl - binarySearch(potions, target);
        }

        return ans;
    }

    public static int binarySearch(int[] potions, long target) {

        int length = potions.length;
        int left = 0;
        int right = length - 1;
        int ans = length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //  在左侧
            if (potions[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }


}
