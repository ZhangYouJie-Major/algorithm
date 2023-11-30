package com.zhangyoujie.nov;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/11/23
 */
public class Nov_23st {

    public static void main(String[] args) {

        System.out.println(nthUglyNumber(1600));
    }

    public static String entityParser(String text) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("&apos;", "'");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        map.put("&quot;", "\"");
        map.put("&amp;", "&");
        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            String key = stringStringEntry.getKey();
            String value = stringStringEntry.getValue();
            text = text.replaceAll(key, value);
        }
        return text;
    }

    public ListNode reverseList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode last = head;
        ListNode curr = head.next;
        ListNode temp;

        while (null != curr) {
            temp = curr;
            curr = curr.next;
            temp.next = head;
            head = temp;
        }
        last.next = null;
        return head;

    }

    public static int nthUglyNumber(int n) {

        List<Long> list = new ArrayList<>();
        int[] arr = new int[]{2, 3, 5};
        list.add(1L);

        for (int i = n - 2; i >= 0; i--) {
            long limit = list.get(list.size() - 1);
            long count = Long.MAX_VALUE;
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < arr.length; k++) {
                    if (list.get(j) * arr[k] <= limit) {
                        continue;
                    }
                    count = Math.min(count, list.get(j) * arr[k]);
                }
            }
            list.add(count);
        }

        return list.get(n - 1).intValue();

    }




    public static class ListNode {
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
