package com.zhangyoujie.jan;

import java.util.*;

public class Jan_7st_周赛 {


    public static void main(String[] args) {
        System.out.println(minMovesToCaptureTheQueen(1, 1, 8, 8, 2, 3));
    }


    public static int minMovesToCaptureTheQueen(int a, int b,
                                                int c, int d,
                                                int e, int f) {
        // 保证车和皇后同一列  象不在同一列 或者 象在车 皇后的行外
        if (a == e && (c != e || ok(b, d, f)) ||
                // 保证车和皇后同一行  象不在同一行 或者 象在车 皇后的列外
                (b == f && (d != f || ok(a, c, e))) ||
                // 保证象和皇后同一对角线 车不和皇后同一对角线 或者不在行中间 或者不在列中间
                // 对角线分两种 a+b = c+d || a-b = c-d
                (c + d == e + f && ((a + b != e + f) || ok(d, b, f))) ||
                (c - d == e - f && ((a - b != e - f || ok(d, b, f))))
        ) return 1;
        return 2;
    }

    public static boolean ok(int l, int m, int r) {
        return m < Math.min(l, r) || m > Math.max(l, r);
    }

    public static void dfs(int[] start, int[] target, int count) {
        if (start[0] < 0 || start[0] >= 8 || start[1] < 0 || start[1] >= 8) {
            return;
        }

        boolean[][] visited = new boolean[8][8];
        visited[start[0]][start[1]] = true;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start[0], start[1], 0});

        int[][] dictionary = new int[][]{{-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {2, 1}, {2, -1}};
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            System.out.println("Visited: (" + poll[0] + ", " + poll[1] + ")");
            for (int r = 0; r < dictionary.length; r++) {
                int newX = poll[0] + dictionary[r][0];
                int newY = poll[1] + dictionary[r][1];
                int ctn = poll[2] + 1;

                boolean visit = newX > 0 && newX < 8 && newY > 0 && newY < 8 && !visited[newX][newY];
                if (visit) {

                    visited[newX][newY] = true;
                    if (newX == target[0] && newY == target[1]) {
//                        Math.min(maxCount, ctn);
                    }
                    queue.offer(new int[]{newX, newY, ctn});
                }
            }
        }
    }

    public static int maximumSetSize(int[] nums1, int[] nums2) {
        int length = nums1.length;
        Map<Integer, Integer> map1 = new LinkedHashMap<>();
        Map<Integer, Integer> map2 = new LinkedHashMap<>();
        for (int i = 0; i < length; i++) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
        }
        return map2.size();

    }

    public static int areaOfMaxDiagonal(int[][] dimensions) {
        double maxL = 0;
        int maxArea = 0;
        for (int[] dimension : dimensions) {
            double l = Math.sqrt(dimension[0] * dimension[0] + dimension[1] * dimension[1]);
            if (l > maxL) {
                maxL = l;
                maxArea = dimension[0] * dimension[1];
            } else if (l == maxL) {
                maxArea = Math.max(maxArea, dimension[0] * dimension[1]);
            }
        }
        return maxArea;
    }

}
