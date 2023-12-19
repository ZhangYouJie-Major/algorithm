package com.zhangyoujie;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/12/16
 */
public class Dec_16st {

    public static void main(String[] args) {
        CountIntervals countIntervals = new CountIntervals();
        countIntervals.add(2, 3);
        countIntervals.add(7, 10);
        countIntervals.add(5, 8);
        originalDigits("121");
    }


    public static String originalDigits(String s) {
        // 创建一个 Map 用于存储数字和其英文表示
        Map<Integer, Character> numberWordsMap = new HashMap<>();

        // 将数字和英文表示放入 Map 中
        numberWordsMap.put(0, (char) ('z' + 'e' + 'r' + 'o'));
        numberWordsMap.put(1, (char) ('o' + 'n' + 'e'));
        numberWordsMap.put(2, (char) ('t' + 'w' + 'o'));
        numberWordsMap.put(3, (char) ('t' + 'h' + 'r' + 'e' + 'e'));
        numberWordsMap.put(4, (char) ('f' + 'o' + 'u' + 'r'));
        numberWordsMap.put(5, (char) ('f' + 'i' + 'v' + 'e'));
        numberWordsMap.put(6, (char) ('s' + 'i' + 'x'));
        numberWordsMap.put(7, (char) ('s' + 'e' + 'v' + 'e' + 'n'));
        numberWordsMap.put(8, (char) ('e' + 'i' + 'g' + 'h' + 't'));
        numberWordsMap.put(9, (char) ('n' + 'i' + 'n' + 'e'));
        return "numberWordsMap";
    }

    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < dictionary.length; i++) {
            set.add(dictionary[i]);
        }
        int length = s.length();
        //标识只分割前i个字符  最少能剩下几个
        int[] dp = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            dp[i] = dp[i - 1];
            for (int j = 0; j < i; j++) {

            }
        }


        return 1;

    }

}

class CountIntervals {

    TreeMap<Integer, Integer> intervalTree = new TreeMap<>();
    int ctn = 0;

    public CountIntervals() {

    }

    public void add(int left, int right) {
        //找到比right小的区间 如果区间的右边界大于left 说明 左边和区间有交集 合并区间
        Map.Entry<Integer, Integer> interval = intervalTree.floorEntry(right);
        while (null != interval && interval.getValue() >= left) {
            int l = interval.getKey();
            int r = interval.getValue();
            left = Math.min(left, l);
            right = Math.max(right, r);
            ctn -= r - l + 1;
            intervalTree.remove(l);
            interval = intervalTree.floorEntry(right);

        }
        ctn += right - left + 1;
        intervalTree.put(left, right);

    }

    public int count() {
        return ctn;
    }
}
