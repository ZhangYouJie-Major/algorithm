package com.zhangyoujie.dec;

import sun.plugin.WJcovUtil;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhangyoujie
 * @date 2023/12/23
 */
public class Dec_23st {

    public static void main(String[] args) {
        System.out.println(minStoneSum(new int[]{5, 4, 9}, 2));
    }

    public static int minStoneSum(int[] piles, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int length = piles.length;
        for (int i = 0; i < length; i++) {
            priorityQueue.add(piles[i]);
        }

        for (int i = 0; i < k; i++) {
            Integer poll = priorityQueue.poll();
            priorityQueue.add(poll - poll / 2);
        }

        int sum = 0;
        while (!priorityQueue.isEmpty()) {
            sum += priorityQueue.poll();
        }
        return sum;
    }
}
