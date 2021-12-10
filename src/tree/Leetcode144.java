package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Verge
 * @Date 2021/12/10 20:18
 * @Version 1.0
 */
public class Leetcode144 {
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);

            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }

            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }

        return list;
    }
}
