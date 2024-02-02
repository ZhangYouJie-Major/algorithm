package com.zhangyoujie.jan;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2024/1/31
 */
public class Jan_31st {

    public static void main(String[] args) {
        Jan_31st st = new Jan_31st();
        System.out.println(st.countKeyChanges("mDVD"));
    }

    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean valid = false;

            for (int i = 0; i < k; i++) {
                long v = 0;
                for (int j = 0; j < composition.get(i).size(); j++) {
                    v += Math.max((long) composition.get(i).get(j) * mid - stock.get(j), 0) * cost.get(j);
                }
                if (v <= budget) {
                    valid = true;
                    break;
                }
            }
            if (valid) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;

    }

    public int countKeyChanges(String s) {
        int length = s.length();
        int ans = 0;
        for (int i = 1; i < length; i++) {
            ans += Character.toLowerCase(s.charAt(i)) - Character.toLowerCase(s.charAt(i - 1)) != 0 ? 1 : 0;
        }
        return ans;

    }

    public int maximumLength(int[] nums) {
        int length = nums.length;
        Map<Double, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put((double) num, map.getOrDefault((double) num, 0) + 1);
        }
        Arrays.sort(nums);


        int ans = 1;
        if (map.containsKey(1.0)) {
            ans = (map.get(1.0) % 2 == 0) ? map.get(1.0) : map.get(1.0) - 1;
        }


        for (int i = 0; i < length; i++) {
            double t = nums[i];
            int count = 1;
            while (true) {
                t = Math.sqrt(t);
                if (t == 1) {
                    break;
                }
                if (map.containsKey(t) && map.get(t) == 2) {
                    count += 2;
                } else {
                    break;
                }
            }
            ans = Math.max(count, ans);
        }
        return ans;

    }

    public int[] distinctDifferenceArray(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        for (int i = 0; i < length; i++) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for (int j = 0; j <= i; j++) {
                set1.add(nums[j]);
            }

            for (int j = i; j < length; j++) {
                set2.add(nums[j]);
            }
            ans[i] = set1.size() - set2.size();
        }
        return ans;

    }
}
