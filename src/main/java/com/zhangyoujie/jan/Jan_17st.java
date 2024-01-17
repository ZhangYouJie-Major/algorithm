package com.zhangyoujie.jan;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2024/1/17
 */
public class Jan_17st {

    public static void main(String[] args) {
        Jan_17st st = new Jan_17st();
        System.out.println(st.longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
    }

    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int max = 0;
        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j, matrix, memo));
            }
        }
        return max;
    }

    public int dfs(int x, int y, int[][] matrix, int[][] memo) {

        if (memo[x][y] != 0) {
            return memo[x][y];
        }

        memo[x][y]++;
        for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length
                    && matrix[newX][newY] > matrix[x][y]) {
                // 当前节点向下递归
                memo[x][y] = Math.max(memo[x][y], dfs(newX, newY, matrix, memo) + 1);
            }
        }
        return memo[x][y];
    }

    public static int purchasePlans(int[] nums, int target) {
        int mod = 1_000_000_007;

        int length = nums.length;
        long ans = 0;

        Arrays.sort(nums);
        // 2 3 5 6
        for (int left = 0, right = length - 1; left < right; left++) {
            while (left < right && nums[left] + nums[right] > target) {
                right--;
            }
            ans = (ans + right - left) % mod;
        }
        return (int) ans;

    }


    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int length = nums.length;
        int ans = 0;
        int prod = 1;
        int i = 0;
        for (int j = 0; j < length; j++) {
            prod *= nums[j];
            while (prod >= k && i <= j) {
                prod /= nums[i];
                i++;
            }
            ans += (j - i + 1);
        }
        return ans;
    }


    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            priorityQueue.add(nums[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            priorityQueue.poll();
        }
        return priorityQueue.poll();

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        //  向上递归
        return null != left ? left : right;

    }


    public int maximumNumberOfStringPairs(String[] words) {
        int length = words.length;
        int ans = 0;
        boolean[][] seen = new boolean[26][26];
        for (int i = 0; i < length; i++) {
            int x = words[i].charAt(0) - 'a';
            int y = words[i].charAt(1) - 'a';
            if (seen[y][x]) {
                ans++;
            } else {
                seen[x][y] = true;

            }
        }
        return ans;
    }

}
