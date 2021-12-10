package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Verge
 * @Date 2021/12/10 21:11
 * @Version 1.0
 */
public class Leetcode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null; // 因为当遍历到根节点时，不能保证右子树是否被访问过，所以每次访问完都需要用prev标记一下是否被访问过，若是访问过则直接将根节点弹出
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if (root.right != null && root.right != prev) {
                stack.push(root);
                root = root.right;
            } else {
                list.add(root.val);
                prev = root;
                root = null;
            }
        }
        return list;
    }
}
