package com.zhangyoujie.mar;

import com.zhangyoujie.tool.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangyoujie
 * @date 2024/3/12
 */
public class Mar_12st {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(-1);
        FindElements findElements = new FindElements(root);
        System.out.println(findElements.find(1));
        System.out.println(findElements.find(3));
        System.out.println(findElements.find(5));

    }

}


class FindElements {

    Set<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        root.val = 0;
        dfs(root);
    }

    public void dfs(TreeNode node) {
        if (null == node) {
            return;
        }
        set.add(node.val);
        if (null != node.left) {
            node.left.val = node.val * 2 + 1;
            set.add(node.left.val);
            dfs(node.left);
        }
        if (null != node.right) {
            node.right.val = node.val * 2 + 1;
            set.add(node.right.val);
            dfs(node.right);
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
