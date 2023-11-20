package com.zhangyoujie;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyoujie
 * @date 2023/11/20
 */
public class Nov_20st {

    public static int maximumSum(int[] nums) {
        int length = nums.length;

        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int sum = 0;
            int target = nums[i];
            while (target != 0) {
                sum += target % 10;
                target /= 10;
            }
            if (map.containsKey(sum)) {
                max = Math.max(max, map.get(sum) + nums[i]);
                map.put(sum, Math.max(map.get(sum), nums[i]));
            } else {
                map.put(sum, nums[i]);
            }
        }

        return max;
    }
}
