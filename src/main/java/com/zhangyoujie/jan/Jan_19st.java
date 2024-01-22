package com.zhangyoujie.jan;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2024/1/19
 */
public class Jan_19st {

    public static void main(String[] args) {
        Jan_19st st = new Jan_19st();
        System.out.println(st.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},
                5, 3));
    }

    int ans = 0;

    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;

        int[][] dp = new int[m + 1][n + 1];
        for (int k = 0; k < length; k++) {
            int one = countOne(strs[k]);
            int zero = strs[k].length() - one;
            for (int i = m; i >= 0; i--) {
                for (int j = n; j >= 0; j--) {
                    dp[i][j] = Math.max(dp[i][j],
                            (i >= zero && j >= one ? dp[i - zero][j - one] + 1 : 0));
                }
            }
        }
        return dp[m][n];
    }

    private int countOne(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    private void dfs(int index, String[] strs, int m, int n, List<String> path) {
        int mc = 0;
        int nc = 0;

        for (String s : path) {
            int one = Integer.bitCount(Integer.parseInt(s, 2));
            nc += one;
            mc += s.length() - one;
        }
        if (mc <= m && nc <= n) {
            ans = Math.max(ans, path.size());
        }
        if (mc > m || nc > n || index == strs.length) {
            return;
        }

        //不选i
        dfs(index + 1, strs, m, n, path);

        path.add(strs[index]);
        dfs(index + 1, strs, m, n, path);
        path.remove(path.size() - 1);
    }

    public int backpack(int[] w, int[] v, int volume) {
        int[][] dp = new int[w.length + 1][2];
        for (int i = 1; i <= w.length; i++) {
            for (int j = 0; j <= volume - w[i]; j++) {
                dp[i][j + w[i]] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
            }
        }

        return 1;

    }

    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size(), s1 = 0, s2 = 0;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            int a = nums1.get(i);
            int b = nums2.get(i);
            pairs[i][0] = a;
            pairs[i][1] = b;
            s1 += a;
            s2 += b;
        }
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int[] f = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int a = pairs[i][0];
            int b = pairs[i][1];
            for (int j = i + 1; j > 0; j--) {
                f[j] = Math.max(f[j], f[j - 1] + a + b * j);
            }
        }
        for (int t = 0; t <= n; t++) {
            if (s1 + s2 * t - f[t] <= x) {
                return t;
            }
        }
        return -1;

    }


    private boolean isOk(int x1, int y1, int x2, int y2) {
        return (x1 == x2 || y1 == y2 || x1 + y1 == x2 + y1 || x1 - x2 == y1 - y2);
    }


    public int trap(int[] height) {
        int length = height.length;
        int[] prefix = new int[length];
        int[] suffix = new int[length];
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
            prefix[i] = max;
        }
        max = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (height[i] > max) {
                max = height[i];
            }
            suffix[i] = max;
        }
        int ans = 0;
        for (int i = 1; i < length - 1; i++) {
            int h = Math.min(prefix[i], suffix[i]);
            ans += h > height[i] ? h - height[i] : 0;
        }

        return ans;

    }
}
