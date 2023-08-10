package com.zhangyoujie;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangyoujie
 * @date 2023/7/25
 */
public class July_25 {


    public static int halveArray(int[] nums) {
        //使用优先队列 优先队列默认是小顶堆 反转比较器 变成大顶堆
        int ans = 0;

        PriorityQueue<Double> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        int length = nums.length;
        double sum = 0;
        double mid = 0;

        for (int i = 0; i < length; i++) {
            priorityQueue.add((double) nums[i]);
            sum += nums[i];
        }


        mid = sum / 2;
        while (sum > mid) {
            double poll = priorityQueue.poll();
            double midPoll = poll / 2;
            priorityQueue.add(midPoll);
            sum -= midPoll;
            ans++;
        }
        return ans;

    }

    public static void main(String[] args) {
        int i = largestRectangleArea(new int[]{1, 1});
        System.out.println(i);
    }

    /**
     * 构建单调递增栈 用来找到左右边界
     *
     * @param heights 柱子高度
     * @return 最大面积
     */
    public static int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int ans = 0;

        Deque<Integer> deque = new ArrayDeque<Integer>();

        for (int i = 0; i < n; i++) {
            //满足单调递增栈 全部弹出 构成左边界
            while (!deque.isEmpty() && heights[deque.peek()] >= heights[i]) {
                deque.pop();
            }
            left[i] = deque.isEmpty() ? -1 : deque.peek();

            deque.push(i);

        }

        deque.clear();

        for (int i = n - 1; i >= 0; i--) {
            //满足单调递增栈 全部弹出 构成左边界
            while (!deque.isEmpty() && heights[deque.peek()] >= heights[i]) {
                deque.pop();
            }
            right[i] = deque.isEmpty() ? n : deque.peek();

            deque.push(i);

        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

}
