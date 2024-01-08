package com.zhangyoujie.dec;

import java.util.*;

public class Dec_31st_周赛 {

    public static void main(String[] args) {
//        System.out.println("aaaa".indexOf("aa"));
        System.out.println(maximumLength("aada"));
    }

    public static int maximumLength(String s) {

        int max = -1;
        int length = s.length();
        List<Integer>[] group = new List[26];
        Arrays.setAll(group, i -> new ArrayList<>());
        int ctn = 0;
        for (int i = 0; i < length; i++) {
            ctn++;
            if (i == length - 1 || s.charAt(i) != s.charAt(i + 1)) {
                group[s.charAt(i) - 'a'].add(ctn);
                ctn = 0;
            }
        }
        for (List<Integer> list : group) {
            if (list.size() == 0) continue;
            list.add(0);
            list.add(0);
            list.sort(Comparator.reverseOrder());
            max = Math.max(max, Math.max(list.get(0) - 2, Math.max(Math.min(list.get(0) - 1, list.get(1)), list.get(2))));
        }

        return max > 0 ? max : -1;
    }

    public static boolean isSpecial(String s) {
        return s.chars().distinct().count() == 1;
    }

    public boolean hasTrailingZeros(int[] nums) {
        int length = nums.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] % 2 == 0) {
                count++;
            }
        }
        return count >= 2;

    }
}
