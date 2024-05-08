package com.zhangyoujie.mar;

import java.util.Arrays;

/**
 * @author zhangyoujie
 * @date 2024/3/27
 */
public class Mar_27st {

    public int countWays(int[][] ranges) {

        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        int ans = 1;
        int maxR = -1;
        for (int[] range : ranges) {
            if (range[0] > maxR) {
                ans = ans * 2 % 1_000_000_000;
            }
            maxR = Math.max(maxR, range[1]);
        }
        return ans;

    }
}
