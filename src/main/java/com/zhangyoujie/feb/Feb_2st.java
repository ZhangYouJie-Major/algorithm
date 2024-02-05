package com.zhangyoujie.feb;

import java.util.Arrays;

/**
 * @author zhangyoujie
 * @date 2024/2/2
 */
public class Feb_2st {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int length = aliceValues.length;
        Integer[] index = new Integer[length];
        for (int i = 0; i < length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> aliceValues[b] + bobValues[b] - (aliceValues[a] + bobValues[a]));

        int ans = 0;
        for (int i = 0; i < length; i++) {
            ans += i % 2 == 0 ? aliceValues[index[i]] : -bobValues[index[i]];
        }
        return Integer.compare(ans, 0);

    }
}
