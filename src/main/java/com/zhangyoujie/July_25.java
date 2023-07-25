package com.zhangyoujie;

import java.util.Comparator;
import java.util.PriorityQueue;

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
}
