package com.zhangyoujie.dec;

import org.omg.CORBA.IRObject;
import sun.plugin.WJcovUtil;

import javax.lang.model.type.ArrayType;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangyoujie
 * @date 2023/12/23
 */
public class Dec_23st {

    public static void main(String[] args) {
//        minImpossibleOR(new int[]{5, 3, 2});
        colorTheArray(4, new int[][]{{0, 2}, {1, 2}, {3, 1}, {1, 1}, {2, 1}});
    }

    public String[] findWords(String[] words) {
        String inputString1 = "qwertyuiop";
        String inputString2 = "asdfghjkl";
        String inputString3 = "zxcvbnm";
        // 使用 Set 存储每个字符
        Set<Character> charSet1 = new HashSet<>();
        Set<Character> charSet2 = new HashSet<>();
        Set<Character> charSet3 = new HashSet<>();
        for (char c : inputString1.toCharArray()) {
            charSet1.add(c);
        }
        for (char c : inputString2.toCharArray()) {
            charSet2.add(c);
        }
        for (char c : inputString3.toCharArray()) {
            charSet3.add(c);
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            Set<Character> charSet4 = new HashSet<>();
            for (int i1 = 0; i1 < words.length; i1++) {
                String word = words[i];
                for (char c : word.toCharArray()) {
                    charSet4.add(Character.toLowerCase(c));
                }
            }
            if (charSet1.containsAll(charSet4) ||
                    charSet2.containsAll(charSet4) ||
                    charSet3.containsAll(charSet4)
            ) {
                list.add(words[i]);
            }
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }


    public static int[] colorTheArray(int n, int[][] queries) {
        int[] count = new int[queries.length];
        int[] temp = new int[n + 2];

        int ctn = 0;
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0] + 1;
            int value = queries[i][1];
            if (temp[index] > 0) {
                // 如果两边相同 先减去两边那的数组
                ctn -= (temp[index] == temp[index - 1] ? 1 : 0) + (temp[index] == temp[index + 1] ? 1 : 0);
            }
            temp[index] = value;
            ctn += (temp[index] == temp[index - 1] ? 1 : 0) + (temp[index] == temp[index + 1] ? 1 : 0);
            count[i] = ctn;
        }

        return count;
    }

    public int findFinalValue(int[] nums, int original) {
        int mask = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果num[i]是original的倍数
            if (nums[i] % original == 0) {
                int k = nums[i] / original;
                mask |= k;
            }
        }
        mask = ~mask;
        return original * (mask & -mask);

    }

    public static int minImpossibleOR(int[] nums) {

        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if ((num & (num - 1)) == 0) {
                target |= num;
            }
        }

        target = ~target;
        return target & -target;

    }

    Node pre;
    Node head;

    public Node treeToDoublyList(Node root) {
        if (null == root) {
            return null;
        }
        dfs(root);
        //形成一个循环
        head.left = pre;
        pre.right = head;

        return head;
    }

    private void dfs(Node node) {
        if (null == node)
            return;
        dfs(node.left);
        if (null != pre) {
            pre.right = node;
        } else {
            // 第一次访问 定义为链表的头结点
            head = node;
        }
        node.left = pre;
        pre = node;
        dfs(node.right);
    }


    public static int twoCitySchedCost(int[][] costs) {
        int length = costs.length;
        int sum = 0;
        Arrays.sort(costs, (a, b) -> a[0] - a[1] - (a[1] - b[1]));
        for (int i = 0; i < length; i++) {
            sum += i < length / 2 ? costs[i][0] : costs[i][1];
        }

        return sum;
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] ans = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            /*
             * target = (success + spells[i] - 1) / spells[i] - 1
             *  = success /  spells[i] + 1 - 1 / spells[i] - 1
             *  =  success /  spells[i] - 1 / spells[i] 可以确保找的数字是严格小于等于 target
             */
            long target = (success + spells[i] - 1) / spells[i] - 1;
            ans[i] = potions.length - binarySearch(target, potions);
        }

        return ans;
    }

    public static int binarySearch(long target, int[] potions) {
        int ans = potions.length;
        int left = 0;
        int right = potions.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        //前缀和 + 滑动窗口
        int length = nums.length;
        int max = 0;
        int[] sum = new int[length + 1];
        for (int i = 0; i < length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        for (int i = 0; i < length - firstLen + 1; i++) {
            int max1 = sum[i + firstLen] - sum[i];

            int max2 = 0;
            // 第二个滑动窗口在第一个的左边
            for (int j = 0; j + secondLen - 1 < i; j++) {
                max2 = Math.max(max2, sum[j + secondLen] - sum[j]);
            }
            // 第二个滑动窗口在第一个的右边
            for (int j = i + firstLen; j < length - secondLen + 1; j++) {
                max2 = Math.max(max2, sum[j + secondLen] - sum[j]);
            }

            max = Math.max(max, max1 + max2);
        }
        return max;
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        int left = 0;
        for (int i = 0; i < length; i++) {
            map.merge(nums[i], 1, Integer::sum);
            while (map.get(nums[i]) > k) {
                map.merge(nums[left++], -1, Integer::sum);
            }
            max = Math.max(max, i - left + 1);
        }
        return max;

    }

    public static int minStoneSum(int[] piles, int k) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        int length = piles.length;
        for (int i = 0; i < length; i++) {
            priorityQueue.add(piles[i]);
        }

        for (int i = 0; i < k; i++) {
            Integer poll = priorityQueue.poll();
            priorityQueue.add(poll - poll / 2);
        }

        int sum = 0;
        while (!priorityQueue.isEmpty()) {
            sum += priorityQueue.poll();
        }
        return sum;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
