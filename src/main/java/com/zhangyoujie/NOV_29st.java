package com.zhangyoujie;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/11/29
 */
public class NOV_29st {


    public static void main(String[] args) {

    }


    public int hammingWeight(int n) {

        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                sum++;
            }
        }
        return sum;
    }

    // 00000
    public static boolean isPowerOfTwo(int n) {
        return n > 0 & (n & -n) == n;
    }

    public int missingNumber(int[] nums) {
        int length = nums.length;
        int ans = length * (length + 1) / 2;
        for (int i = 0; i < length; i++) {
            ans -= nums[i];
        }
        return ans;
    }

    public static List<String> letterCasePermutation(String s) {


        List<String> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {

            if (Character.isLetter(s.charAt(i))) {
                if (list.size() == 0) {
                    list.add(String.valueOf(Character.toLowerCase(s.charAt(i))));
                    list.add(String.valueOf(Character.toUpperCase(s.charAt(i))));
                } else {
                    List<String> temp = new ArrayList<>();
                    for (String s1 : list) {
                        temp.add(s1 + Character.toLowerCase(s.charAt(i)));
                        temp.add(s1 + Character.toUpperCase(s.charAt(i)));
                    }
                    list = temp;
                }
            } else {
                if (list.size() == 0) {
                    list.add(String.valueOf(s.charAt(i)));
                } else {
                    List<String> temp = new ArrayList<>();
                    for (String s1 : list) {
                        temp.add(s1 + s.charAt(i));
                    }
                    list = temp;
                }
            }
        }
        return list;

    }

    public boolean isPowerOfFour(int n) {
        // 二进制 10101010101010101010101010101010 4的次方奇数位的都是0 唯一的1都是偶数位
        return n > 0 && (n & (n - 1)) == 0 && ((n & 0xaaaaaaaa) == 0);
    }

    public static int hammingDistance(int x, int y) {
        int sum = 0;
        int z = x ^ y;
        for (int i = 0; i < 32; i++) {
            if ((z & (1 << i)) == (1 << i)) {
                sum++;
            }
        }
        return sum;
    }
}


class SmallestInfiniteSet {

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    public SmallestInfiniteSet() {
        for (int i = 0; i < 1000; i++) {
            priorityQueue.add(i + 1);
        }
    }

    public int popSmallest() {
        if (!priorityQueue.isEmpty()) {
            return priorityQueue.poll();
        }
        return -1;
    }

    public void addBack(int num) {
        if (!priorityQueue.contains(num)) {
            priorityQueue.add(num);
        }

    }
}