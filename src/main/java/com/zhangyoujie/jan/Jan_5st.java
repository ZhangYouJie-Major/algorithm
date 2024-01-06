package com.zhangyoujie.jan;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhangyoujie
 * @date 2024/1/5
 */
public class Jan_5st {


    public static void main(String[] args) {
        canSeePersonsCount(new int[]{10, 6, 8, 5, 11, 9});
    }

    public static int[] canSeePersonsCount(int[] heights) {

        int length = heights.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && heights[deque.peek()] < heights[i]) {
                deque.pop();
            }
            ans[i] = deque.isEmpty() ? length : i;
            deque.push(i);
        }
        return ans;


    }
}
