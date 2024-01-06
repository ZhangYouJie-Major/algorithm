package com.zhangyoujie.jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangyoujie
 * @date 2024/1/4
 */
public class Jan_4st {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(2);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<Integer> list3 = Arrays.asList(6, 5, 7);
        List<Integer> list4 = Arrays.asList(4, 1, 8, 3);
        triangle.add(list1);
        triangle.add(list2);
        triangle.add(list3);
        triangle.add(list4);
        int i = minimumTotal(triangle);
        System.out.println(i);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            dp[i][triangle.get(i).size() - 1] = dp[i - 1][triangle.get(i - 1).size() - 1] +
                    triangle.get(i).get(triangle.get(i).size() - 1);
        }
        int row = dp.length;
        int col = dp[0].length;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (i > j) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }

            }
        }
        int min = Integer.MAX_VALUE;
        for (int i : dp[dp.length - 1]) {
            min = Math.min(i, min);
        }

        return min;

    }

    public static int maximumRows(int[][] matrix, int numSelect) {

        int row = matrix.length;
        int col = matrix[0].length;
        int[] ctn = new int[row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    ctn[i] |= 1 << j;
                }
            }
        }

        int ans = 0;
        for (int mask = 1; mask < 1 << col; ++mask) {
            if (Integer.bitCount(mask) != numSelect) {
                continue;
            }
            int t = 0;
            // 选中n列为1的二进制数字
            for (int x : ctn) {
                if ((x & mask) == x) {
                    t++;
                }
            }
            ans = Math.max(ans, t);

        }
        return ans;

    }
}
