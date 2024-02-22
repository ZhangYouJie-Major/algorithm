package com.zhangyoujie.july;

import com.zhangyoujie.tool.ListNode;

import javax.swing.text.html.HTMLWriter;
import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/7/1
 */
public class July_6st {


    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes > k) {
            return k;
        } else if (numOnes + numZeros > k) {
            return numOnes;
        } else {
            return numOnes + numZeros - (k - numOnes - numZeros);
        }
    }


    public static List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();

        if (finalSum % 2 != 0) {
            return res;
        }

        for (long i = 2; i <= finalSum; i += 2) {
            res.add(i);
            finalSum -= i;
        }
        res.set(res.size() - 1, res.get(res.size() - 1) + finalSum);

        return res;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode header = new ListNode();


        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        Deque<Integer> deque3 = new ArrayDeque<>();
        while (l1 != null) {
            deque1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            deque2.add(l2.val);
            l2 = l2.next;
        }

        int step = 0;

        while (!deque1.isEmpty() || !deque2.isEmpty()) {

            int sum = 0;
            if (!deque1.isEmpty()) {
                sum += deque1.pollLast();
            }
            if (!deque2.isEmpty()) {
                sum += deque2.pollLast();
            }
            sum += step;
            step = sum / 10;
            deque3.addFirst(sum % 10);
        }

        if (step != 0) {
            deque3.addFirst(step);
        }

        while (!deque3.isEmpty()){
            ListNode node = new ListNode(deque3.pollFirst());

            node.next = header;
            header = node;
        }
        return header;

    }

}
