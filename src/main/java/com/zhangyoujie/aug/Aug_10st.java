package com.zhangyoujie.aug;

import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * @author zhangyoujie
 * @date 2023/8/10
 */
public class Aug_10st {

    /**
     * 排序加贪心
     *
     * @param capacity        容量
     * @param rocks           石头
     * @param additionalRocks 额外石头
     * @return 最多能装的袋子数
     */
    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        int length = capacity.length;

        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            ans[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(ans);
        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (ans[i] == 0) {
                sum++;
                continue;
            }
            if (additionalRocks > 0 && additionalRocks - ans[i] >= 0) {
                additionalRocks -= ans[i];
                sum++;
            } else {
                break;
            }
        }
        return sum;
    }

}
