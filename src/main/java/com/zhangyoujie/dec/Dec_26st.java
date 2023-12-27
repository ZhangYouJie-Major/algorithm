package com.zhangyoujie.dec;

import java.util.Arrays;

/**
 * @author zhangyoujie
 * @date 2023/12/26
 */
public class Dec_26st {


    public int maxStudents(char[][] seats) {
        int row = seats.length;
        int col = seats[0].length;

        // dfs(i,j) 表示第i排的j的状态下 前i排的最大学生数
        int[] a = new int[row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (seats[i][j] == '.') {
                    // 用二进制标记第j列有位置
                    a[i] |= 1 << j;
                }
            }
        }
        int[][] memo = new int[row][1 << col];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(row - 1, a[row - 1], memo, a);
    }

    private int dfs(int i, int j, int[][] memo, int[] a) {
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (i == 0) {
            if (j == 0) {
                return 0;
            }
            int lb = j & -j;
            return memo[i][j] = dfs(i, j & ~(lb * 3), memo, a) + 1;
        }
        int res = dfs(i - 1, a[i - 1], memo, a);
        for (int s = j; s > 0; s = (s - 1) & j) {
            if ((s & (s << 1)) == 0) {
                int t = a[i - 1] & ~(s << 1 | s >> 1);
                res = Math.min(res, dfs(i - 1, t, memo, a) + Integer.bitCount(s));
            }
        }
        return memo[i][j] = res;
    }
}
