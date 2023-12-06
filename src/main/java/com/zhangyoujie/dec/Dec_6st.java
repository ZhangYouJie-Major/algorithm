package com.zhangyoujie.dec;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyoujie
 * @date 2023/12/6
 */
public class Dec_6st {

    public static void main(String[] args) {
        System.out.println(minimumTotalPrice(4, new int[][]{{0, 1}, {1, 2}, {1, 3}},
                new int[]{2, 2, 10, 6}, new int[][]{{0, 3}, {2, 1}, {2, 3}}
        ));
    }

    public static int beautifulSubstrings(String s, int k) {
        int sum = 0;
        char[] charArray = s.toCharArray();
        int length = charArray.length;
        int k1 = 0;
        int k2 = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (charArray[j] == 'a' || charArray[j] == 'e' ||
                        charArray[j] == 'i' || charArray[j] == 'o' ||
                        charArray[j] == 'u') {
                    k1++;
                } else {
                    k2++;
                }
                if (k1 == k2 && k1 * k2 % k == 0) {
                    sum++;
                }
            }
            k1 = 0;
            k2 = 0;
        }
        return sum;
    }


    public static int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        int length = edges.length;
        List<Integer>[] g = new List[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        //构建邻邻表
        for (int i = 0; i < length; i++) {
            g[edges[i][0]].add(edges[i][1]);
            g[edges[i][1]].add(edges[i][0]);
        }
        //统计每个节点在trips 经过的次数
        int[] count = new int[n];
        for (int i = 0; i < trips.length; i++) {
            //深度遍历找到trips的end值 向上递归标记整条路径
            dfs(trips[i][0], -1, trips[i][1], g, count);
        }
        int[] dp = dp(0, -1, price, g, count);
        return Math.min(dp[0], dp[1]);

    }

    public static boolean dfs(int node, int parent, int end, List<Integer>[] g, int[] count) {
        if (node == end) {
            count[node]++;
            return true;
        }
        for (Integer child : g[node]) {
            if (child == parent) {
                continue;
            }
            if (dfs(child, node, end, g, count)) {
                count[node]++;
                return true;
            }
        }
        return false;
    }

    public static int[] dp(int node, int parent, int[] price, List<Integer>[] g, int[] count) {
        int[] res = {price[node] * count[node], price[node] * count[node] / 2};

        for (Integer child : g[node]) {
            if (child == parent) {
                continue;
            }
            int[] pair = dp(child, node, price, g, count);
            res[0] += Math.min(pair[0], pair[1]); //如果当前节点没有减半 则取子节点减半、未减版的最小值
            res[1] += pair[0];  //如果当前节点减半 则子节点取未减半的值

        }
        return res;
    }
}
