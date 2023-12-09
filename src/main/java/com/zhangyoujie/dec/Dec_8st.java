package com.zhangyoujie.dec;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/12/8
 */
public class Dec_8st {

    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    public static int minPathSum(int[][] grid) {
        int col = grid.length;
        int row = grid[0].length;
        int[][] dp = new int[col][row];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < row; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < col; i++) {
            for (int j = 1; j < row; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        return dp[col - 1][row - 1];
    }

    public static boolean isHappy(int n) {

        int max = 2147483646;
        long sum = n;
        int index = 0;
        while (sum != 1 && sum < max && index < 100) {
            long temp = 0;
            char[] charArray = String.valueOf(sum).toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                int anInt = Integer.parseInt(String.valueOf(charArray[i]));
                temp += (long) anInt * anInt;
            }
            sum = temp;
            index++;
        }

        return sum == 1;
    }

    public static long minimumSteps(String s) {

        /*
         *  根据贪心策略 需要将字符左侧是'1' 右侧是'0'的数据左移动
         * 所以最小的移动次数 等价于 讲所有的0  向左移动的最小距离
         * 每次记录下一个 0 的位置  直到遍历完所有的0即可
         */
        long sum = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0, j = 0; i < charArray.length; i++) {
            if (charArray[i] == '0') {
                sum += i - j;
                j++;
            }
        }

        return sum;
    }

    public static int findMinimumOperations(String s1, String s2, String s3) {
        if (s1.charAt(0) != s2.charAt(0) || s2.charAt(0) != s3.charAt(0) ||
                s1.charAt(0) != s3.charAt(0)
        ) return -1;
        int minLength = Math.min(Math.min(s1.length(), s2.length()), s3.length());

        int temp = 0;
        int i = 0;
        while (i < minLength) {
            if (s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)
                    && s1.charAt(i) == s3.charAt(i)) {
                temp++;
            } else {
                break;
            }
            i++;
        }
        return s1.length() + s2.length() + s3.length() - temp * 3;

    }

    public static int nextBeautifulNumber(int n) {

        Map<Integer, Integer> map = new HashMap<>();
        while (true) {
            n++;
            String s = String.valueOf(n);
            for (int i = 0; i < s.length(); i++) {
                int temp = Integer.parseInt(String.valueOf(s.charAt(i)));
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
            boolean flag = true;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (!entry.getValue().equals(entry.getKey())) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return n;
            }
            map.clear();

        }
    }

    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();

        Set<String> contain = new HashSet<>();
        for (int i = 0; i < dictionary.length; i++) {
            contain.add(dictionary[i]);
            for (int j = 0; j < dictionary[i].length(); j++) {
                contain.add(dictionary[i].substring(0, i) + dictionary[i].substring(i + 1));
                for (int k = j + 1; k < dictionary[i].length(); k++) {
                    String temp = dictionary[i];
                    contain.add(temp.substring(0, j) + temp.substring(j + 1, k) + temp.substring(k + 1));
                }
            }
        }
        for (int i = 0; i < queries.length; i++) {
            if (contain.contains(queries[i])) {
                ans.add(queries[i]);
                continue;
            }
            boolean flag = true;
            for (int j = 0; j < queries[i].length() && flag; j++) {
                if (contain.contains(queries[i].substring(0, i) + queries[i].substring(i + 1))) {
                    ans.add(queries[i]);
                    flag = false;
                }
                for (int k = j + 1; k < queries[i].length() && flag; k++) {
                    String temp = queries[i].substring(0, j) + queries[i].substring(j + 1, k) + queries[i].substring(k + 1);
                    if (contain.contains(temp)) {
                        ans.add(queries[i]);
                        flag = false;
                    }
                }
            }
        }
        return ans;
    }

    // 移除指定索引位置的两个字符
    private static String removeChars(String input, int index1, int index2) {
        StringBuilder result = new StringBuilder(input);
        result.deleteCharAt(Math.max(index1, index2));
        result.deleteCharAt(Math.min(index1, index2));
        return result.toString();
    }

    public static long maxTaxiEarnings(int n, int[][] rides) {

        // 用Hash表记录 所有end为i的所有车程
        //dp[i] 表示到达第i个地点能获取的最大值 显然 dp[0] = 0;
        //1、如果有多个乘客在i点下车  dp[i] = dp[i-1] 和 dp[rides[0]]+ rides[1]- rides[0] +rides[2] 的最大值
        //2、如果没有乘客在i点下车  dp[i] = dp[i-1]
        long[] dp = new long[n + 1];
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] ride : rides) {
            map.putIfAbsent(ride[1], new ArrayList<>());
            map.get(ride[1]).add(ride);
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            for (int[] ints : map.getOrDefault(i, new ArrayList<>())) {
                dp[i] = Math.max(dp[i], dp[ints[0]] + ints[1] - ints[0] + ints[2]);
            }
        }
        return dp[n];
    }
}
