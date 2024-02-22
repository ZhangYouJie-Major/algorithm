package com.zhangyoujie.feb;

import com.zhangyoujie.tool.TreeNode;

import java.util.Arrays;

/**
 * @author zhangyoujie
 * @date 2024/2/22
 */
public class Feb_22st {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int length = preorder.length;
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return new TreeNode(preorder[0]);
        }
        // 确定左子树的大小
        int leftSize = indexOf(postorder, preorder[1]) + 1;
        int[] pre1 = Arrays.copyOfRange(preorder, 1, leftSize + 1);
        int[] pre2 = Arrays.copyOfRange(preorder, leftSize + 1, length);
        int[] post1 = Arrays.copyOfRange(postorder, 0, leftSize);
        int[] post2 = Arrays.copyOfRange(postorder, leftSize, length - 1);
        TreeNode left = constructFromPrePost(pre1, post1);
        TreeNode right = constructFromPrePost(pre2, post2);
        return new TreeNode(preorder[0], left, right);

    }

    private int indexOf(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
