package com.zhangyoujie.jan;

import com.zhangyoujie.tool.TreeNode;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2024/1/8
 */
public class Jan_8st {


    public int rob(TreeNode root) {
        int[] dfs = dfs(root);
        return Math.max(dfs[0], dfs[1]);
    }

    public int[] dfs(TreeNode node) {
        if (null == node) {
            return new int[]{0, 0};
        }
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        //选当前节点 左右子树不选 + 当前值
        int rob = left[1] + right[1] + node.val;
        // 不选当前节点 Math.max(左子树选,左子不树选) + Math.max(右子树选,右子不树选)
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{rob, notRob};
    }

    public int[] shortestSeq(int[] big, int[] small) {
        // 100000

        return new int[1];
    }


    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();

    String s;


    List<List<Integer>> ans1 = new ArrayList<>();
    List<Integer> path1 = new ArrayList<>();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        dfs(1);
        return ans1;
    }

    public void dfs(int index) {

        if (path1.size() == k) {
            ans1.add(new ArrayList<>(path1));
            return;
        }
        // 起始位置大于 n  - (k - path1.size()) + 1 就是无效递归
        for (int i = index; i <= n - (k - path1.size()) + 1; i++) {
            path1.add(i);
            dfs(i + 1);
            path1.remove(path1.size() - 1);
        }
    }

    public List<List<String>> partition(String s) {
        // aab  选逗号的地方 a,ab  a,a,b  插入逗号的下标只能是小于length-1
        this.s = s;
        dfs(0, 0);
        return ans;
    }

    public void dfs(int start, int end) {
        int length = s.length();
        if (start == length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        //不选end插入逗号
        if (end < length - 1)
            dfs(start, end + 1);
        //选择end插入逗号
        if (isPalindrome(start, end)) {
            // 判断start end 是否为回文串
            path.add(s.substring(start, end + 1));
            // 选择end的下一个字符
            dfs(end + 1, end + 1);
            path.remove(path.size() - 1);
        }
    }

    public boolean isPalindrome(int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    public static int numberOfBoomerangs(int[][] points) {
        int length = points.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) continue;
                for (int k = 0; k < length; k++) {
                    if (j == k || k == i) continue;
                    int x1 = points[i][0];
                    int y1 = points[i][1];
                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int x3 = points[k][0];
                    int y3 = points[k][1];

                    int l = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
                    int r = (x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3);
                    if (l == r) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
