package com.zhangyoujie;

/**
 * @author zhangyoujie
 * @date 2023/8/14
 */
public class Aug_14 {

    public static void main(String[] args) {
        int i = equalSubstring("abcd", "bcdf", 3);
        System.out.println(i);
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int left = 0;
        int right = 0;
        //窗口
        int sum = 0;
        int res = 0;

        while (right < length) {
            sum += Math.abs(s.charAt(right) - t.charAt(right));

            //移动左边减少
            while (sum > maxCost) {
                //窗口左边界右移
                sum -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;

    }
}
