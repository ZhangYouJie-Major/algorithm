package com.zhangyoujie;

import javax.print.attribute.IntegerSyntax;
import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/7/1
 */
public class July_17st {

    public static void main(String[] args) {
        String s = addStrings("0", "0");
        System.out.println(s);
    }

    public static String addStrings(String num1, String num2) {

        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        Deque<Integer> deque3 = new ArrayDeque<>();

        String[] split1 = num1.split("");
        String[] split2 = num2.split("");

        for (int i = 0; i < split1.length; i++) {
            deque1.addLast((Integer.parseInt(split1[i])));
        }
        for (int i = 0; i < split2.length; i++) {
            deque2.addLast((Integer.parseInt(split2[i])));
        }

        int step = 0;

        while (!deque1.isEmpty() || !deque2.isEmpty()) {
            int a = deque1.isEmpty() ? 0 : deque1.pollLast();
            int b = deque2.isEmpty() ? 0 : deque2.pollLast();
            int sum = a + b + step;
            deque3.addLast(sum % 10);
            step = sum / 10;
        }
        if (step != 0) {
            deque3.addLast(step);
        }

        StringBuffer stringBuffer = new StringBuffer();
        while (!deque3.isEmpty()) {
            stringBuffer.append(deque3.pollLast());
        }

        return stringBuffer.toString();

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
