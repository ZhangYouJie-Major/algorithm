package com.zhangyoujie.jan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhangyoujie
 * @date 2024/1/15
 */
public class Jan_15st {

    public static void main(String[] args) {
        System.out.println(beautifulIndices("isawsquirrelnearmysquirrelhouseohmy", "my", "squirrel", 15));
        kmp("isawsquirrelnearmysquirrelhouseohmy", "my");
    }


    public static int kmp(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();
        int i = 0;
        int j = 0;
        while (i < sLen && j < pLen) {
            if (sCharArray[i] == pCharArray[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == pLen) {
            return i - j;
        } else {
            return -1;
        }
    }

    public static List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> indexA = find(s, a);
        List<Integer> indexB = find(s, b);
        List<Integer> ans = new ArrayList<>();
        for (Integer c : indexA) {
            for (Integer d : indexB) {
                if (Math.abs(c - d) <= k) {
                    ans.add(c);
                    break;
                }
            }
        }
        return ans;

    }

    private static List<Integer> find(String s, String target) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length() - target.length() + 1; ) {
            if (s.charAt(i) == target.charAt(0)) {
                boolean flag = true;
                for (int j = 0; j < target.length(); j++) {
                    if (s.charAt(i + j) != target.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans.add(i);
                    i += target.length();
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        return ans;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode tail = head;
        Map<Integer, Integer> map = new HashMap<>();
        while (null != tail) {
            map.put(tail.val, map.getOrDefault(tail.val, 0) + 1);
            tail = tail.next;
        }
        List<Integer> list = new ArrayList<>();
        map.forEach((k, v) -> {
            if (v == 1) {
                list.add(k);
            }
        });
        if (list.size() == 0) {
            return null;
        }
        List<Integer> sort = list.stream().sorted().collect(Collectors.toList());
        ListNode header = new ListNode();
        ListNode tailer = header;
        for (int i = 0; i < sort.size(); i++) {
            tailer.val = sort.get(i);
            if (i != sort.size() - 1) {
                tailer.next = new ListNode();
                tailer = tailer.next;
            }
        }
        return header.next;

    }

}


class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}