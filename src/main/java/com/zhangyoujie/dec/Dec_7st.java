package com.zhangyoujie.dec;


import com.zhangyoujie.tool.ListNode;
import com.zhangyoujie.tool.TreeNode;
import jdk.nashorn.internal.ir.IfNode;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/12/7
 */
public class Dec_7st {

    public static void main(String[] args) {
        System.out.println('a' - 'A');

    }

    public int monotoneIncreasingDigits(int n) {
        while (n >= 0) {
            String s = Integer.toString(n);
            char[] charArray = s.toCharArray();
            int length = charArray.length;
            boolean flag = true;
            for (int i = 1; i < length; i++) {
                if (charArray[i] - charArray[i - 1] < 0) {
                    flag = false;
                }
            }
            if (flag) {
                return n;
            }
            n--;
        }
        return 0;
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        leafSimilarDfs(root1, deque1);
        leafSimilarDfs(root2, deque2);
        if (deque1.size() == deque2.size()) {
            while (!deque1.isEmpty()) {
                if (!deque1.pop().equals(deque2.pop())) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public static void leafSimilarDfs(TreeNode root, Deque<Integer> deque) {
        if (null != root) {
            if (null == root.left && null == root.right) deque.push(root.val);
            leafSimilarDfs(root.left, deque);
            leafSimilarDfs(root.right, deque);

        }
    }


    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int ans = -1;
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            g[edge[0]].add(new int[]{edge[1], edge[2]});
            g[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        Set<Integer> visit = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (findTheCityDfs(i, -1, g, visit) <= distanceThreshold) {
                ans = Math.max(ans, i);
            }
            visit.clear();
        }
        return ans;
    }

    public static int findTheCityDfs(int node, int parent, List<int[]>[] g, Set<Integer> visit) {
        if (visit.contains(node)) {
            return 0;
        }
        visit.add(node);
        int tail = 0;
        for (int[] ints : g[node]) {
            if (node == parent) {
                continue;
            }
            tail += ints[1] + findTheCityDfs(ints[0], node, g, visit);
        }
        return tail;
    }

    public static int minReorder(int n, int[][] connections) {
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        //给每条边都增加一个方向 0代表原来的方向 1代表反方向 从0开始遍历 统计反方向的边数
        for (int[] ints : connections) {

            // 例如 1-> 0 g[1] = [{0,0} ]
            // g[0] = [{1,1} ]
            g[ints[0]].add(new int[]{ints[1], 1}); // 统计反方向 所以从a -> b 的值都得 +1
            g[ints[1]].add(new int[]{ints[1], 0});
        }
        //遍历每一条变 使都能到达0节点
        return dfs(0, -1, g);
    }

    public static int dfs(int node, int parent, List<int[]>[] g) {
        int ans = 0;
        for (int[] ints : g[node]) {
            if (ints[0] == parent) {
                continue;
            }
            ans += ints[1] + dfs(ints[0], node, g);
        }
        return ans;
    }

    public static List<List<Integer>> largeGroupPositions(String s) {

        List<List<Integer>> ans = new ArrayList<>();

        char[] charArray = s.toCharArray();
        int length = charArray.length;

        Map<Integer, List<Integer>> map = new LinkedHashMap<>();

        char temp = charArray[0];
        int left = 0;
        for (int i = 1; i < length; i++) {
            if (charArray[i] == temp) {
                if (i - left >= 2) {
                    if (map.containsKey(left)) {
                        List<Integer> list = map.get(left);
                        list.remove(list.size() - 1);
                        list.add(i);
                        map.put(left, list);
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(left);
                        list.add(i);
                        map.put(left, list);
                    }
                }
            } else {
                temp = charArray[i];
                left = i;
            }
        }
        Set<Map.Entry<Integer, List<Integer>>> entries = map.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : entries) {
            ans.add(entry.getValue());
        }
        return ans;

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        Deque<Integer> deque3 = new ArrayDeque<>();

        while (null != l1) {
            deque1.push(l1.val);
            l1 = l1.next;
        }
        while (null != l2) {
            deque2.push(l2.val);
            l2 = l2.next;
        }
        int mod = 0;
        while (!deque1.isEmpty() || !deque2.isEmpty()) {
            int value1 = !deque1.isEmpty() ? deque1.pop() : 0;
            int value2 = !deque2.isEmpty() ? deque2.pop() : 0;
            int value = (value1 + value2 + mod) % 10;
            mod = (value1 + value2 + mod) / 10;
            deque3.push(value);
        }
        if (mod != 0) deque3.push(mod);
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!deque3.isEmpty()) {
            tail.next = new ListNode(deque3.pop());
            tail = tail.next;
        }
        return head.next;
    }

    // 将数组转换为链表
    private static ListNode arrayToList(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        ListNode head = new ListNode(array[0]);
        ListNode current = head;

        for (int i = 1; i < array.length; i++) {
            current.next = new ListNode(array[i]);
            current = current.next;
        }

        return head;
    }


}

