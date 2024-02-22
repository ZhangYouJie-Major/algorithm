package com.zhangyoujie.feb;

import com.zhangyoujie.tool.TreeNode;

import java.util.Arrays;

/**
 * @author zhangyoujie
 * @date 2024/2/20
 */
public class Feb_20st {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = postorder.length;
        if (length == 0) {
            return null;
        }
        // 查询出左子树的大小
        int leftSize = indexOf(inorder, postorder[length - 1]);
        int[] pre1 = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] pre2 = Arrays.copyOfRange(inorder, leftSize + 1, length);
        int[] in1 = Arrays.copyOfRange(postorder, 0, leftSize);
        int[] in2 = Arrays.copyOfRange(postorder, leftSize, length - 1);
        TreeNode left = buildTree(pre1, in1);
        TreeNode right = buildTree(pre2, in2);

        return new TreeNode(postorder[length - 1], left, right);
    }

    private int indexOf(int[] t, int target) {
        for (int i = 0; i < t.length; i++) {
            if (t[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
