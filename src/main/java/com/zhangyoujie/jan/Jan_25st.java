package com.zhangyoujie.jan;

import java.util.List;

/**
 * @author zhangyoujie
 * @date 2024/1/25
 */
public class Jan_25st {

    public static void main(String[] args) {
        System.out.println(Integer.bitCount(10));
        System.out.println(Integer.bitCount(1));
        System.out.println(Integer.bitCount(2));
        System.out.println();
        System.out.println();
    }

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (Integer.bitCount(i) == k)
                sum += nums.get(i);
        }
        return sum;
    }
}
