package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode94 {

    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
       travel(root);
       return list;
    }

    public void travel (TreeNode root) {
        if (root == null) return;
        travel(root.left);
        list.add(root.val);
        travel(root.right);
    }

    // 递归解法
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            list.add(root.val);

            root = root.right;
        }

        return list;
    }



}
