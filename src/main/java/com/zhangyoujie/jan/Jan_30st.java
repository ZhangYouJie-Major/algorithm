package com.zhangyoujie.jan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangyoujie
 * @date 2024/1/30
 */
public class Jan_30st {

    public int minimumSeconds(List<Integer> nums) {

        // 把
        // 1 2 3 4 5   n = 5
        Map<Integer, List<Integer>> map = new HashMap<>();
        int size = nums.size();
        int res = size;
        for (int i = 0; i < size; i++) {
            map.computeIfAbsent(nums.get(i), k -> new ArrayList<>()).add(i);
        }
        for (List<Integer> positions : map.values()) {
            int mx = positions.get(0) + size - positions.get(positions.size() - 1);
            for (int i = 1; i < positions.size(); i++) {
                mx = Math.max(mx, positions.get(i) - positions.get(i - 1));
            }
            res = Math.min(res, mx / 2);
        }
        return res;

    }
}
