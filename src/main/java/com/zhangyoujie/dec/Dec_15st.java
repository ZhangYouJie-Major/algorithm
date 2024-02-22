package com.zhangyoujie.dec;

import com.zhangyoujie.tool.TreeNode;

import java.util.*;

/**
 * @author zhangyoujie
 * @date 2023/12/15
 */
public class Dec_15st {


    public static void main(String[] args) {
        // 构建一个示例二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        reverseOddLevels(root);
    }

    public static TreeNode reverseOddLevels(TreeNode root) {

        if (null == root) {
            return null;
        }
        boolean step = false;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int rz = queue.size();
            List<TreeNode> arr = new ArrayList<>();

            //遍历当前队列 获取下一层的所有节点
            for (int i = 0; i < rz; i++) {
                TreeNode node = queue.poll();
                if (step) {
                    //如果是奇数层 把当前层的所有node添加到 arr中
                    arr.add(node);
                }
                if (null != node && null != node.left) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            //双指针互换两边的值
            if (step) {
                int left = 0;
                int right = arr.size() - 1;
                while (left <= right) {
                    int temp = arr.get(right).val;
                    arr.get(right).val = arr.get(left).val;
                    arr.get(left).val = temp;
                    left++;
                    right--;
                }
            }
            step = !step;
        }
        return root;
    }

}

