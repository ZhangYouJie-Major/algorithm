package com.zhangyoujie.dec;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhangyoujie
 * @date 2023/12/19
 */
public class Dec_19st {

    public static void main(String[] args) {
        findPeakGrid(new int[][]{});
    }

    public static int[] findPeakGrid(int[][] mat) {

        int row = mat.length;
        if (0 == row) {
            return new int[]{};
        }
        int col = mat[0].length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                priorityQueue.add(new int[]{mat[i][j], i, j});
            }
        }
        int[] poll = priorityQueue.poll();
        return new int[]{poll[1], poll[2]};

    }
}
