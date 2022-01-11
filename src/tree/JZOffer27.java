package tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author Verge
 * @Date 2022/1/11 20:30
 * @Version 1.0
 */
public class JZOffer27 {
    // 递归
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        recur(root);
        return root;
    }

    public void recur(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        recur(root.left);
        recur(root.right);
    }

    // 迭代
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = temp;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return root;
    }



}
