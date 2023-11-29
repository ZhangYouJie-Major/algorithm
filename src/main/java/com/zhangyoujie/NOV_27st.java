package com.zhangyoujie;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhangyoujie
 * @date 2023/11/27
 */
public class NOV_27st {


    public static void main(String[] args) {
        String s = "bcabc";
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'a']++;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (nums[s.charAt(i) - 'a'] > 1) {
                s = s.substring(0, i) + s.substring(i + 1);
            }
        }

        System.out.println(nums);

    }

    public static int sumSubarrayMins(int[] arr) {


        int mod = 1000000007;

        int length = arr.length;
        Deque<Integer> deque = new ArrayDeque<>();
        long sum = 0;
        // dp[i][j] 表示下标i->j数组的最小值
        int[] left = new int[length];
        int[] right = new int[length];
        for (int i = 0; i < length; i++) {
            //维护单调递增栈
            while (!deque.isEmpty() && arr[i] <= arr[deque.peek()]) {
                deque.pop();
            }
            left[i] = i - (deque.isEmpty() ? -1 : deque.peek());
            deque.push(i);
        }
        deque.clear();
        for (int i = length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && arr[i] < arr[deque.peek()]) {
                deque.pop();
            }
            right[i] = (deque.isEmpty() ? length : deque.peek()) - i;
            deque.push(i);
        }
        for (int i = 0; i < length; i++) {
            sum = (sum + (long) right[i] * left[i] * arr[i]) % mod;
        }
        return (int) sum;

    }
}
