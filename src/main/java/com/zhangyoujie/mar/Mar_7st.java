package com.zhangyoujie.mar;

/**
 * @author zhangyoujie
 * @date 2024/3/7
 */
public class Mar_7st {


    public int[] divisibilityArray(String word, int m) {
        int length = word.length();
        int[] ans = new int[length];

        long cur = 0;
        for (int i = 0; i < length; i++) {
            cur = (cur * 10 + Integer.parseInt(String.valueOf(word.charAt(i)))) % m;
            ans[i] = cur == 0 ? 1 : 0;
        }
        return ans;

    }
}
