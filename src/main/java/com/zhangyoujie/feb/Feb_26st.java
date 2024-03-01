package com.zhangyoujie.feb;

import com.zhangyoujie.tool.TreeNode;

/**
 * @author zhangyoujie
 * @date 2024/2/26
 */
public class Feb_26st {

    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }

    public void dfs(TreeNode node, int low, int high) {
        if (null == node) {
            return;
        }
        if (node.val >= low && node.val <= high) {
            sum += node.val;
        }
        dfs(node.left, low, high);
        dfs(node.right, low, high);
    }
}
