package com.zhangyoujie.dec;

import java.util.*;

public class Dec_17st {

    public static int[][] divideArray(int[] nums, int k) {
        int length = nums.length;
        Arrays.sort(nums);

        int[][] ans = new int[length / 3][3];
        for (int i = 0; i < length; i += 3) {
            if (nums[i + 1] - nums[i] > k || nums[i + 2] - nums[i] > k) {
                ans = new int[0][0];
                break;
            }
            ans[i / 3] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        return ans;
    }


    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        int ans1 = 0;
        int ans2 = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (set.contains(grid[i][j])) {
                    ans1 = grid[i][j];
                } else {
                    set.add(grid[i][j]);
                }
            }
        }
        for (int i = 1; i <= row * row; i++) {
            if (!set.contains(i)) {
                ans2 = i;
            }
        }
        return new int[]{ans1, ans2};
    }

}
