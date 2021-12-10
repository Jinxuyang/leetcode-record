package tree;

import java.util.*;

/**
 * @Author Verge
 * @Date 2021/12/10 21:49
 * @Version 1.0
 */
public class Leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> deque = new ArrayDeque<>();
        if (root != null) {
            deque.add(root);
        }
        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int n = deque.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = deque.poll();
                level.add(node.val);

                if (node.left != null) deque.add(node.left);
                if (node.right != null) deque.add(node.right);
            }
            res.add(level);
        }
        return res;
    }
}
