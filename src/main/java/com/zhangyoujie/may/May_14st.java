package com.zhangyoujie.may;

import java.util.HashMap;
import java.util.Map;

public class May_14st {

    public int minimumRounds(int[] tasks) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        int ans = 0;
        for (Integer value : map.values()) {
            if (value == 1) {
                return -1;

            }
            if (value % 3 == 0) {
                ans += value / 3;
            } else {
                ans += value / 3 + 1;
            }

        }

        return ans;

    }
}
