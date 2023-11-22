package com.zhangyoujie;

/**
 * @author zhangyoujie
 * @date 2023/11/22
 */


public class Nov_22st {

    public static void main(String[] args) {
        int ans = minPathCost(new int[][]{{5, 3}, {4, 0}, {2, 1}},
                new int[][]{{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}});
        System.out.println(ans);
    }

    public static int minPathCost(int[][] grid, int[][] moveCost) {
        int row = grid.length;
        int col = grid[0].length;

        // 从0,0 移动到 i,j 花费的最小路径
        int[][] dp = new int[row][col];

        dp[0] = grid[0].clone();

        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < col; k++) {
                    min = Math.min(min, dp[i - 1][k] + moveCost[grid[i - 1][k]][j]);
                }
                dp[i][j] = min + grid[i][j];
            }
        }
        for (int i = 0; i < col; i++) {
            ans = Math.min(dp[row - 1][i], ans);
        }
        return ans;

        // dp[i][j] = math.min(dp[i-1[[j],dp[i[[j-1]) + moveCost[grid[][],j];

    }
}
