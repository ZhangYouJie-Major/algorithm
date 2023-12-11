package com.zhangyoujie.dec;

import sun.plugin.WJcovUtil;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/12/11
 */
public class Dec_11st {

    public static void main(String[] args) {
        System.out.println(minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        /*
         * 滑动窗口 当某个num[i]超过k时候 滑动左边的指针 然后每个数的次数不断的-1
         * 如果窗口内的num[i]不大于k时  此时窗口的大小为 i - left + 1
         * ans = Math.max(ans, i - left + 1)
         */
        int length = nums.length;
        int ans = 0;
        int left = 0;
        Map<Integer, Integer> ctn = new HashMap<>();
        for (int i = 0; i < length; i++) {
            ctn.merge(nums[i], 1, Integer::sum);
            while (ctn.get(nums[i]) > k) {
                ctn.merge(nums[left++], -1, Integer::sum);
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }

    public static int minimumEffortPath(int[][] heights) {
        // 因为给定的 1 <= heights[i][j] <= 10 ^ 6
        /* m行 n列
         * 我们进行深度遍历的时候 可以设置一个值 target 然后小于这个值才能进行遍历 如果heights 右下角的被访问过 则存在
         * 一条路径 所有的值都小于target 然后我们可以在 0 - 10 ^ 6之间二分查找 直到找到这个最小值
         */

        int[][] dictions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int row = heights.length;
        int col = heights[0].length;

        int left = 0;
        int right = 999999;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            Queue<int[]> deque = new LinkedList<>();
            boolean[][] seen = new boolean[row][col];
            seen[0][0] = true;
            deque.offer(new int[]{0, 0});
            while (!deque.isEmpty()) {
                int[] cell = deque.poll();
                int x = cell[0];
                int y = cell[1];
                for (int[] diction : dictions) {
                    int nx = diction[0] + x;
                    int ny = diction[1] + y;

                    if (nx >= 0 && nx < row && ny >= 0 && ny < col
                            && !seen[nx][ny] && Math.abs(heights[x][y] - heights[nx][ny]) <= mid) {
                        deque.offer(new int[]{nx, ny});
                        seen[nx][ny] = true;
                    }
                }
            }
            if (seen[row - 1][col - 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static String longestNiceSubstring(String s) {
        List<String> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                for (int k = i; k <= j; k++) {
                    set.add(charArray[k]);
                }
                boolean a = true;
                for (int k = i; k <= j; k++) {
                    if (Character.isUpperCase(charArray[k])) {
                        if (!set.contains(Character.toLowerCase(charArray[k]))) {
                            a = false;
                        }
                    } else {
                        if (!set.contains(Character.toUpperCase(charArray[k]))) {
                            a = false;
                        }
                    }
                }
                if (a) {
                    list.add(s.substring(i, j + 1));
                }
                set.clear();
            }
        }
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            max = Math.max(max, list.get(i).length());
        }
        for (int i = 0; i < list.size(); i++) {
            if (max == list.get(i).length()) {
                return list.get(i);
            }
        }
        return "";

    }
}
