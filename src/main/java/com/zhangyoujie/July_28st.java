package com.zhangyoujie;

import javax.swing.text.html.HTMLWriter;
import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/7/28
 */
public class July_28st {

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    }

    public static int[] finalPrices(int[] prices) {
        int length = prices.length;

        int[] ans = new int[length];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            while (!deque.isEmpty() && prices[deque.peek()] >= prices[i]) {
                Integer index = deque.pop();
                ans[index] = prices[index] - prices[i];
            }
            deque.push(i);
        }

        return ans;

    }


}
