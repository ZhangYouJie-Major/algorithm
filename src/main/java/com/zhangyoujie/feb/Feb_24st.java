package com.zhangyoujie.feb;

import com.zhangyoujie.tool.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangyoujie
 * @date 2024/2/24
 */
public class Feb_24st {

    public static void main(String[] args) {
        int[] a = new int[]{6, 2, 13, 2, 4, 9, 15, 14};
        Feb_24st st = new Feb_24st();
        TreeNode treeNode = new TreeNode(9);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(14);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(20);
        treeNode.right.left.left = new TreeNode(12);


        List<List<Integer>> lists = st.closestNodes(treeNode, Arrays.asList(19, 10, 9, 17, 19, 6, 10, 19, 13, 6));
        System.out.println(lists);

    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> arr = new ArrayList<>();

        dfs(root, arr);
        int length = arr.size();
        int[] a = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = arr.get(i);
        }
        List<List<Integer>> ans = new ArrayList<>();

        for (Integer query : queries) {
            // -(index+1)
            int index = index(a, query);
            int mx = index == length ? -1 : a[index];
            if (index == length || a[index] != query) {
                index--;
            }
            int mn = index < 0 ? -1 : a[index];

            ans.add(Arrays.asList(mn, mx));

        }
        return ans;
    }

    private void dfs(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }
        dfs(node.left, arr);
        arr.add(node.val);
        dfs(node.right, arr);
    }

    private int index(int[] a, int target) {
        int left = -1;
        int right = a.length;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (a[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }

        }
        return right;

    }
}
