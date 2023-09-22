package com.zhangyoujie;

/**
 * @author zhangyoujie
 * @date 2023/9/22
 */
public class Aug_22st {

    public static void main(String[] args) {
        System.out.println(waysToBuyPensPencils(100, 1, 1));
    }

    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {
        int ans = 0, ctn = 0;
        while (cost1 * ctn <= total) {
            ans += (total - cost1 * ctn) / cost2 + 1;
            ctn++;
        }
        return ans;
    }
}
