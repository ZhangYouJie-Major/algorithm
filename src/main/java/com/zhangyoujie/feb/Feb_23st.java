package com.zhangyoujie.feb;

import com.zhangyoujie.tool.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhangyoujie
 * @date 2024/2/23
 */
public class Feb_23st {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(8);
        treeNode.right = new TreeNode(9);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(7);
        Feb_23st feb_23st = new Feb_23st();
        System.out.println(feb_23st.kthLargestLevelSum(treeNode, 2));
    }

    public long kthLargestLevelSum(TreeNode root, int k) {

        List<Long> ans = new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            long sum = 0;
            Deque<TreeNode> temp = queue;
            queue = new ArrayDeque<>();
            for (TreeNode treeNode : temp) {
                sum += treeNode.val;
                if (null != treeNode.left) queue.add(treeNode.left);
                if (null != treeNode.right) queue.add(treeNode.right);
            }
            ans.add(sum);
        }
        if (ans.size() < k) {
            return -1;
        }
        ans.sort(Collections.reverseOrder());

        return ans.get(k - 1);

    }
}
