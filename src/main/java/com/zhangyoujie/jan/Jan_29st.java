package com.zhangyoujie.jan;

import java.util.List;

/**
 * @author zhangyoujie
 * @date 2024/1/29
 */
public class Jan_29st {

    public static void main(String[] args) {
        Jan_29st st = new Jan_29st();
        System.out.println(st.numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
    }


    int area = 0;

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    bfs(i, j, grid);
                    max = Math.max(max, area);
                    area = 0;
                }
            }
        }
        return max;

    }

    private void bfs(int i, int j, char[][] grid) {
        grid[i][j] = '0';
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs) {
            int newX = i + dir[0];
            int newY = j + dir[1];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length
                    && grid[newX][newY] == '1') {
                area++;
                bfs(newX, newY, grid);
            }
        }

    }


    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }
        if (jug1Capacity == 0 || jug2Capacity == 0) {
            return targetCapacity == 0 || jug1Capacity + jug2Capacity == targetCapacity;
        }
        return targetCapacity % gcd(jug1Capacity, jug2Capacity) == 0;

    }

    public int gcd(int x, int y) {
        int remainder = x % y;
        while (remainder != 0) {
            x = y;
            y = remainder;
            remainder = x % y;
        }
        return y;

    }

    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {

        int left = 1;
        int right = Integer.MAX_VALUE;
        int ans = 0;
        while (left <= right) {
            int mid = left + (left + right) / 2;
            boolean valid = false;
            // 枚举哪台机器制造
            for (int i = 0; i < k; i++) {
                long spend = 0;
                // 枚举机器的金属
                for (int j = 0; j < n; j++) {
                    spend += Math.max((long) composition.get(i).get(j) * mid - stock.get(j), 0) * cost.get(j);
                }

                if (spend <= budget) {
                    valid = true;
                    break;
                }
            }
            if (valid) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;

    }
}
