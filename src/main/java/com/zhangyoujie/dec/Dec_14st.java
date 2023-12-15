package com.zhangyoujie.dec;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangyoujie
 * @date 2023/12/15
 */
public class Dec_14st {


    private static int[][] sum;

    public static void main(String[] args) {
        System.out.println(findingUsersActiveMinutes(new int[][]{{1, 1}, {2, 2}, {2, 3}}, 4));
    }

    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {

        int[] ans = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            if (map.containsKey(logs[i][0])) {
                map.get(logs[i][0]).add(logs[i][1]);
            } else {
                map.put(logs[i][0], new HashSet<>());
                map.get(logs[i][0]).add(logs[i][1]);
            }
        }
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            Set<Integer> value = entry.getValue();
            count.put(value.size(), count.getOrDefault(value.size(), 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            ans[entry.getKey() - 1] = entry.getValue();
        }
        return ans;
    }


    private static void twoDimensionalPrefixSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        sum = new int[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + grid[i][j];
            }
        }
    }

    /**
     * 查询左上角为x1,y1 右下角为x2-1,y2-1的矩形区域的和
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @return
     */
    private static int query(int x1, int y1, int x2, int y2) {
        return sum[x2][y2] - sum[x2][y1] - sum[x1][y2] + sum[x1][y1];
    }
}
