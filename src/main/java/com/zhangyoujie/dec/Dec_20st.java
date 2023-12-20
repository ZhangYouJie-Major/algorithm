package com.zhangyoujie.dec;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhangyoujie
 * @date 2023/12/20
 */
public class Dec_20st {


    public static void main(String[] args) {
        corpFlightBookings(new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}}, 5);
    }

    public boolean isAcronym(List<String> words, String s) {
        return words.stream()
                .map(item -> String.valueOf(item.charAt(0)))
                .collect(Collectors.joining()).equals(s);

    }

    public static int[] corpFlightBookings(int[][] bookings, int n) {

        /*
         *  int[] ans = new int[]{a1,a2,a3,a4,a5}
         *  int[] diff = new int[5]
         *  diff[0] = a1    diff[1] = a2 - a1  diff[2] = a3 - a2 diff[3] = a4 - a3 diff[4] = a5 - a4
         *  diff的前缀和 sum[0] = a1  sum[1] = diff[0] + diff[1] = a2 ......sum[4] = a5
         *  我们对 diff[0] + v 会产生什么影响呢？
         *  sum[0] = a1 + v
         *  sum[1] =  diff[0] + diff[1] = a1 + v + a2 - a1 = a2 + v
         *  由此我们可以得出 如果我们对原数组的 (i,j) 同时 + v 则我们对差分数组diff diff[i] += v diff[j+1] -= v
         */

        int[] ans = new int[n];
        int[] diff = new int[n + 1];
        for (int[] booking : bookings) {
            int l = booking[0] - 1;
            int r = booking[1] - 1;
            int v = booking[2];
            diff[l] += v;
            diff[r + 1] -= v;
        }
        ans[0] = diff[0];
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] + diff[i];
        }

        return ans;
    }
}
