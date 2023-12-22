package com.zhangyoujie.dec;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/12/21
 */
public class Dec_21st {

    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 3, 9, 2, 7};
        // 6 5 2 1 1 1 1 1
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        System.out.println(maximumSumOfHeights(list));
    }

    public static long maximumSumOfHeights(List<Integer> maxHeights) {
        /*
         * 我们维护每个下标 i 的 左右单调栈 找到左右边界的最大值 left[i] 代表 i 为山峰时候
         * 左右的最大值 所以i 到左右边界的最大值 (a,b) 都有
         * left[i] =  (i - a) * maxHeights[i] + left[a- 1]
         * right[i] = (i - a) * maxHeights[i] + right[a + 1]
         * 可以认为是利用了 单调栈 + dp 去解决子问题 因为在 i 的左右边界 我们需要累加边界外的高度
         *
         * max = Math.max(max ,left[i] + right[i] - maxHeights[i])
         * 因为maxHeights[i]加了两次 所以在计算值的时候 要减去一次
         */
        //6,5,3,9,2,7
        //3,3,3,9,2,2
        int size = maxHeights.size();
        long res = 0;
        long[] left = new long[size];
        long[] right = new long[size];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < size; i++) {
            while (!deque.isEmpty() && maxHeights.get(i) < maxHeights.get(deque.peek())) {
                deque.pop();
            }
            if (deque.isEmpty()) {
                left[i] = (long) (i + 1) * maxHeights.get(i);
            } else {
                left[i] = (long) (i - deque.peek()) * maxHeights.get(i) + left[deque.peek()];
            }
            deque.push(i);
        }

        deque.clear();
        for (int i = size - 1; i >= 0; i--) {
            while (!deque.isEmpty() && maxHeights.get(i) < maxHeights.get(deque.peek())) {
                deque.pop();
            }
            if (deque.isEmpty()) {
                right[i] = (long) (size - i) * maxHeights.get(i);
            } else {
                right[i] = (long) (deque.peek() - i) * maxHeights.get(i) + right[deque.peek()];
            }
            deque.push(i);
        }

        for (int i = 0; i < size; i++) {
            res = Math.max(res, left[i] + right[i] - maxHeights.get(i));
        }

        return res;

    }
}
