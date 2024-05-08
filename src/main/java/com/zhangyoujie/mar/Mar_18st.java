package com.zhangyoujie.mar;

/**
 * @author zhangyoujie
 * @date 2024/3/18
 */
public class Mar_18st {

    public static void main(String[] args) {
        Mar_18st st = new Mar_18st();
        System.out.println(st.maxMoves(new int[][]{{3, 2, 4}, {2, 1, 9}, {1, 1, 7}}));
    }

    int[][] dir = new int[][]{{-1, 1}, {0, 1}, {1, 1}};
    int ans = 0;

    public int maxMoves(int[][] grid) {

        int row = grid.length;
        for (int i = 0; i < row; i++) {
            dfs(grid, 0, i, 0);
        }
        return ans;
    }

    public void dfs(int[][] grid, int count, int x, int y) {

        int row = grid.length;
        int col = grid[0].length;

        ans = Math.max(ans, y);
        if (ans == col - 1) {
            return;
        }

        for (int[] ints : dir) {
            int newX = x + ints[0];
            int newY = y + ints[1];
            if (newX >= 0 && newY >= 0 && newX < row && newY < col && grid[newX][newY] > grid[x][y]) {
                dfs(grid, count + 1, newX, newY);
            } else {
                ans = Math.max(ans, count);
            }
        }
        grid[x][y] = 0;
    }


}
