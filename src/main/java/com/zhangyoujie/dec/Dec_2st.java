package com.zhangyoujie.dec;

import java.util.*;

public class Dec_2st {

    public boolean carPooling(int[][] trips, int capacity) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i, 0);
        }
        for (int i = 0; i < trips.length; i++) {
            int cap = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];
            for (int j = from; j <= to; j++) {
                Integer contain = list.get(j);
                if (contain + cap > capacity) {
                    return false;
                }
                list.set(j, cap + contain);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }


}
