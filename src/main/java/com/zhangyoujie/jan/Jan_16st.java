package com.zhangyoujie.jan;

import java.util.Arrays;

/**
 * @author zhangyoujie
 * @date 2024/1/16
 */
public class Jan_16st {

    public static void main(String[] args) {

    }

    private static final int mod = 1_000_000_007;

    public int count(String num1, String num2, int min_sum, int max_sum) {

        int ans = calc(num2, min_sum, max_sum) - calc(num1, min_sum, max_sum);

        int sum = 0;
        for (char c : num1.toCharArray()) {
            sum += c - '0';
        }
        if (min_sum <= sum && sum <= max_sum) {
            ans++;
        }

        return ans % mod;
    }

    private int calc(String s, int minSum, int maxSum) {
        int n = s.length();
        int[][] memo = new int[n][Math.min(9 * n, maxSum) + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(0, 0, true, s.toCharArray(), minSum, maxSum, memo);
    }

    private int dfs(int i, int sum, boolean isLimit, char[] s, int minSum, int maxSum, int[][] memo) {
        if (sum > maxSum) {
            return 0;
        }
        if (i == s.length) {
            return sum >= minSum ? 1 : 0;
        }
        if (!isLimit && memo[i][sum] != -1) {
            return memo[i][sum];
        }
        int up = isLimit ? s[i] - '0' : 9;
        int res = 0;
        for (int d = 0; d <= up; d++) {
            res = (res + dfs(i + 1, sum + d, isLimit && (d == up), s, minSum, maxSum, memo)) % mod;
        }
        if (!isLimit) {
            memo[i][sum] = res;
        }
        return res;
    }
}
