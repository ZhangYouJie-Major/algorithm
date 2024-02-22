package com.zhangyoujie.jan;

import com.zhangyoujie.tool.TreeNode;
import sun.security.provider.Sun;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2024/1/17
 */
public class Jan_17st {

    public static void main(String[] args) {
        Jan_17st st = new Jan_17st();
        System.out.println(st.findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }


    public int findTargetSumWays(int[] nums, int target) {
        int[][] memo = new int[20][40000];
        for (int[] ints : memo) {
            Arrays.fill(ints, -30000);
        }
        return dfs(0, 0, target, nums, memo);
    }

    private int dfs(int index, int sum, int target, int[] nums, int[][] memo) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        if (memo[index][sum + 20000] != -30000) {
            return memo[index][sum + 20000];
        }
        int ans = dfs(index + 1, sum + nums[index], target, nums, memo) +
                dfs(index + 1, sum - nums[index], target, nums, memo);
        memo[index][sum + 20000] = ans;
        return ans;
    }

    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] memo = new int[row][col];

        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans = Math.max(ans, dfs(i, j, matrix, memo));
            }
        }
        return ans;
    }

    public int dfs(int row, int col, int[][] matrix, int[][] memo) {
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        memo[row][col]++;

        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = row + dir[1];
            if (newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol <= matrix[0].length
                    && matrix[newRow][newCol] > matrix[row][col]) {
                memo[row][col] = Math.max(memo[row][col], dfs(newRow, newCol, matrix, memo) + 1);
            }
        }
        return memo[row][col];

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
