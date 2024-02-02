package com.zhangyoujie.feb;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhangyoujie
 * @date 2024/2/1
 */
public class Feb_1st {
    public int[] numsGame(int[] nums) {
        int mod = 1_000_000_007;
        int length = nums.length;
        // 维护较小的一半
        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int[] ans = new int[length];

        long leftSum = 0;
        long rightSum = 0;

        for (int i = 0; i < length; i++) {
            int b = nums[i] - i;
            if (i % 2 == 0) {
                if (!left.isEmpty() && b < left.peek()) {
                    leftSum -= left.peek() - b;
                    left.offer(b);
                    b = left.poll();
                }
                rightSum += b;
                right.offer(b);
                ans[i] = (int) ((rightSum - right.peek() - leftSum) % mod);

            } else {
                if (b > right.peek()) {
                    rightSum += b - right.peek();
                    right.offer(b);
                    b = right.poll();
                }
                leftSum += b;
                left.offer(b);
                ans[i] = (int) ((rightSum - leftSum) % mod);

            }
        }
        return ans;

    }
}
