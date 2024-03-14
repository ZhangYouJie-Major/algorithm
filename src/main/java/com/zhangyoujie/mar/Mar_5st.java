package com.zhangyoujie.mar;

import java.util.List;

/**
 * @author zhangyoujie
 * @date 2024/3/5
 */
public class Mar_5st {

    public int countPaths(int n, int[][] roads) {

        List<Integer>[] g = new List[n];
        for (int[] road : roads) {
            int x = road[0];
            int y = road[1];
            g[x].add(y);
            g[y].add(x);
        }
        return 1;
    }


}
