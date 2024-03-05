package com.zhangyoujie.mar;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhangyoujie
 * @date 2024/3/4
 */
public class Mar_4st {
}


class MyQueue {

    Deque<Integer> list;


    public MyQueue() {
        list = new ArrayDeque<>();
    }

    public void push(int x) {
        list.addFirst(x);
    }

    public int pop() {
        return list.isEmpty() ? -1 : list.pollLast();
    }

    public int peek() {
        return list.isEmpty() ? -1 : list.peekLast();
    }

    public boolean empty() {
        return list.isEmpty();
    }
}