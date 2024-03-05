package com.zhangyoujie.mar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyoujie
 * @date 2024/3/1
 */
public class Mar_2st {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] isRestricted = new boolean[n];
        for (int i : restricted) {
            isRestricted[i] = true;
        }
        List<Integer>[] g = new List[n];
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[0];
            if (!isRestricted[x] && !isRestricted[y]) {
                g[x].add(y);
                g[y].add(x);
            }
        }
        return dfs(0, -1, g);

    }

    private int dfs(int x, int fa, List<Integer>[] g) {
        int ctn = 1;
        for (Integer y : g[x]) {
            if (fa != y) {
                ctn += dfs(y, x, g);
            }
        }
        return ctn;
    }


}
