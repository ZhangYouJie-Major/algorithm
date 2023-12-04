package com.zhangyoujie.dec;


import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/12/1
 */
public class Dec_1st {

    /**
     * 思路1 : 想通过两个 Map<Integer, Set<Integer>> 把两个行的全部元素和两个列的全部元素维护起来
     * 然后再通过遍历arr去除Set中的元素 如果为空则去返回下标 但是时间复杂度超时
     * <p>
     * 思路2：通过Map<Integer, int[]> 维护元素和下标的关系 然后再用两个数组统计分别统计对应列/行的使用次数
     * 那个先到达上限 就直接返回对应的arr元素下标
     *
     * @param arr
     * @param mat
     * @return
     */
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> map = new HashMap<>();
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] rowArray = new int[row];
        int[] colArray = new int[col];
        for (int i = 0; i < arr.length; i++) {
            int[] ints = map.get(arr[i]);
            rowArray[ints[0]]++;
            colArray[ints[1]]++;
            if (rowArray[ints[0]] == col || colArray[ints[1]] == row) {
                return i;
            }
        }
        return -1;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<ListNode> visit = new HashSet<>();
        while (head.next != null) {
            if (visit.contains(head)) {
                return head;
            } else {
                visit.add(head);
            }
            head = head.next;
        }
        return null;
    }

    // cbacdcbc
    // acdb
    public static String removeDuplicateLetters(String s) {

        boolean[] vis = new boolean[26];
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!vis[ch - 'a']) {
                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    } else {
                        break;
                    }
                }
                vis[ch - 'a'] = true;
                sb.append(ch);
            }
            num[ch - 'a'] -= 1;
        }
        return sb.toString();
    }


    public static ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(0, head);
        ListNode tail = node;
        while (tail != null) {
            if (tail.next != null && tail.next.val == val) {
                tail.next = tail.next.next;
                continue;
            }
            tail = tail.next;
        }
        return node.next;
    }

    static int sum = 0;

    public static TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }

        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);

        return root;
    }

    public static void dfs(TreeNode node, PriorityQueue<Integer> queue) {
        if (null == node) {
            return;
        }
        queue.offer(node.val);
        dfs(node.left, queue);
        dfs(node.right, queue);
    }


    public static void dfsSet(TreeNode node, PriorityQueue<Integer> queue) {
        if (null == node) {
            return;
        }
        PriorityQueue<Integer> queueSet = new PriorityQueue<>(queue);
        int sum = 0;
        while (!queueSet.isEmpty() && queueSet.peek() >= node.val) {
            sum += queueSet.poll();
        }
        node.val = sum;
        dfs(node.left, queue);
        dfs(node.right, queue);
    }


    public static void main(String[] args) {
        Integer[] values = {4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8};
        TreeNode root = buildBST(values);
        bstToGst(root);
    }

    public static TreeNode buildBST(Integer[] values) {
        if (values == null || values.length == 0) {
            return null;
        }

        TreeNode[] nodes = new TreeNode[values.length];
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                nodes[i] = new TreeNode(values[i]);
            }
        }

        for (int i = 0; i < values.length; i++) {
            if (nodes[i] != null) {
                int leftIndex = 2 * i + 1;
                int rightIndex = 2 * i + 2;

                if (leftIndex < values.length) {
                    nodes[i].left = nodes[leftIndex];
                }

                if (rightIndex < values.length) {
                    nodes[i].right = nodes[rightIndex];
                }
            }
        }

        return nodes[0];
    }


}

class ListNode {
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



