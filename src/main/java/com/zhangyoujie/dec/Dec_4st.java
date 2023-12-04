package com.zhangyoujie.dec;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author zhangyoujie
 * @date 2023/12/4
 */
public class Dec_4st {

    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }

        bstToGst(root.right);
        sum += root.val;
        root.val = sum;
        bstToGst(root.left);

        return root;
    }

    public static void main(String[] args) {
        // 创建一个示例二叉树
        //         1
        //       /   \
        //      2     3
        //     / \  /   \
        //    4   5 6    7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }

    public static void preorderTraversal(TreeNode root) {
        if (null != root) {
            //1、访问根节点
            System.out.print(root.val + " ");
            //2、递归前序遍历左子树
            preorderTraversal(root.left);
            //3、递归前序遍历右子树
            preorderTraversal(root.right);
        }
    }

    public static void postorderTraversal(TreeNode root) {
        if (null != root) {
            //1、递归前序遍历左子树
            postorderTraversal(root.left);
            //2、递归前序遍历右子树
            postorderTraversal(root.right);
            //3、 访问根节点
            System.out.print(root.val + " ");
        }
    }

    public static void inorderTraversal(TreeNode root) {
        if (null != root) {
            // 1、访问中序遍历左子树
            inorderTraversal(root.left);
            // 2、访问根节点
            System.out.print(root.val + " ");
            // 3、访问中序遍历右子树
            inorderTraversal(root.right);
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (null != root) {
            deque.addFirst(root);
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollLast();
                if (null != treeNode) {
                    temp.add(treeNode.val);
                    if (null != treeNode.left) deque.addFirst( treeNode.left);
                    if (null != treeNode.right) deque.addFirst( treeNode.right);
                }
            }
            ans.add(temp);

        }
        return ans;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
    }
}
