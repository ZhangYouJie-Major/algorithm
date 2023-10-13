package com.zhangyoujie;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhangyoujie
 * @date 2023/9/22
 */
public class Aug_22st {

    public static void main(String[] args) {
        System.out.println(captureForts(new int[]{1, 0, 0, -1, 0, 0, 0, 0, 1}));
    }

    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int ans = 0, ctn = 0;
        while (cost1 * ctn <= total) {
            ans += (total - cost1 * ctn) / cost2 + 1;
            ctn++;
        }
        return ans;
    }

    public static int captureForts(int[] forts) {
        int length = forts.length;

        int ans = 0;
        int left = 0;
        while (left < length) {
            // 找到第一个不为零的数向后遍历
            int right = left + 1;
            if (forts[left] != 0) {
                while (right < length && forts[right] == 0) {
                    right++;
                }
                if (right < length && forts[left] + forts[right] == 0) {
                    ans = Math.max(ans, right - left - 1);
                }
            }
            left = right;


        }
        return ans;

    }


}
