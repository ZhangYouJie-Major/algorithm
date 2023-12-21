package com.zhangyoujie.dec;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangyoujie
 * @date 2023/12/20
 */
public class Dec_20st {


    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));

        NumMatrix matrix = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        System.out.println(matrix.sumRegion(2, 1, 4, 3)); // return 8 (红色矩形框的元素总和)
        System.out.println(matrix.sumRegion(1, 1, 2, 2)); // return 11 (绿色矩形框的元素总和)
        System.out.println(matrix.sumRegion(1, 2, 2, 4)); // return 12 (蓝色矩形框的元素总和)
    }

    public double largestSumOfAverages(int[] nums, int k) {
        int length = nums.length;
        double[] prefix = new double[length + 1];


        for (int i = 0; i < length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // dp[i][j] 标识前i-1个元素分成j组的最大平均值
        double[][] dp = new double[length + 1][k + 1];
        for (int i = 1; i <= length; i++) {
            dp[i][1] = (prefix[i] / i);
        }

        for (int j = 2; j <= k; j++) {
            for (int i = j; i <= length; i++) {
                for (int l = j - 1; l < i; l++) {
                    //从 j-1个数组开始分割 前i-1个  长度为i
                    //  dp[i][j] 从最后一个元素开始分割  知道前面的数组长度为j-1
                    dp[i][j] = Math.max(dp[i][j], dp[l][j - 1] + (prefix[i] - prefix[l]) / (i - l));
                }
            }
        }
        return dp[length][k];
    }

    public boolean isAcronym(List<String> words, String s) {
        return words.stream()
                .map(item -> String.valueOf(item.charAt(0)))
                .collect(Collectors.joining()).equals(s);

    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {

        /*
         *  int[] ans = new int[]{a1,a2,a3,a4,a5}
         *  int[] diff = new int[5]
         *  diff[0] = a1    diff[1] = a2 - a1  diff[2] = a3 - a2 diff[3] = a4 - a3 diff[4] = a5 - a4
         *  diff的前缀和 sum[0] = a1  sum[1] = diff[0] + diff[1] = a2 ......sum[4] = a5
         *  我们对 diff[0] + v 会产生什么影响呢？
         *  sum[0] = a1 + v
         *  sum[1] =  diff[0] + diff[1] = a1 + v + a2 - a1 = a2 + v
         *  由此我们可以得出 如果我们对原数组的 (i,j) 同时 + v 则我们对差分数组diff diff[i] += v diff[j+1] -= v
         */

        int[] ans = new int[n];
        int[] diff = new int[n + 1];
        for (int[] booking : bookings) {
            int l = booking[0] - 1;
            int r = booking[1] - 1;
            int v = booking[2];
            diff[l] += v;
            diff[r + 1] -= v;
        }
        ans[0] = diff[0];
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] + diff[i];
        }

        return ans;
    }
}

class NumArray {
    int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}

class NumMatrix {

    int[][] sum;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        sum = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
    }
}
