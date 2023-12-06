package com.zhangyoujie.dec;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/12/5
 */
public class Dec_5st {

    static long res = 0;






    public static int countCompleteSubstrings(String word, int k) {
        int sum = 0;
        int length = word.length();


        for (int i = 0; i < length; ) {
            int left = i;
            //将字符串拆分成多个子串
            for (i++; i < length && Math.abs(word.charAt(i) - word.charAt(i - 1)) <= 2; i++) ;
            // 题目就转化成求子串中 k个字符中 滑动窗口在k*m下 出现k次的统计
            sum += findCount(word.substring(left, i), k);
        }
        return sum;
    }

    public static int findCount(String s, int k) {
        int res = 0;
        for (int m = 1; m <= 26 && k * m <= s.length(); m++) {
            int[] ctn = new int[26];
            int windows = k * m;
            for (int right = 0; right < s.length(); right++) {
                ctn[s.charAt(right) - 'a']++;
                int left = right + 1 - windows;
                if (left >= 0) {
                    boolean ok = true;
                    for (int i = 0; i < ctn.length; i++) {
                        if (ctn[i] > 0 && ctn[i] != k) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) {
                        res++;
                    }
                    ctn[s.charAt(left) - 'a']--;
                }
            }

        }
        return res;

    }

    public static List<Integer> findPeaks(int[] mountain) {
        List<Integer> ans = new ArrayList<>();
        int length = mountain.length;
        for (int i = 1; i < length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void addEdge(List<Integer>[] g, int u, int v) {
        g[u].add(v);
        g[v].add(u);
    }

    public static void printGraph(int cur, int parent, List<Integer>[] g) {
        List<Integer> nodes = new ArrayList<>();

        for (Integer node : g[cur]) {
            if (node != parent) {
                nodes.add(node);
                printGraph(node, cur, g);
            }
        }
        System.out.println("订单");
    }

    public static long minimumFuelCost(int[][] roads, int seats) {
        int lengthRow = roads.length;

        //初始化邻接表数组
        List<Integer>[] g = new List[lengthRow + 1];
        for (int i = 0; i <= lengthRow; i++) {
            g[i] = new ArrayList();
        }

        // 构建图
        for (int[] road : roads) {
            g[road[0]].add(road[1]);
            g[road[1]].add(road[0]);
        }
        dfs(0, -1, seats, g);
        return res;
    }

    public static int dfs(int cur, int parent, int seats, List<Integer>[] g) {
        int personSum = 1;
        for (Integer node : g[cur]) {
            if (node != parent) {
                int personCnt = dfs(node, cur, seats, g);
                personSum += personCnt;
                //计算子节点到当前节点的总油耗 相当于子节点到当前节点需要几辆车才能坐下 去下一个节点的油耗就是多少
                res += (personCnt + seats - 1) / seats;
            }

        }
        return personSum;
    }

}
