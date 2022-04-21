package dp;

import java.util.HashMap;

/**
 * @Author Verge
 * @Date 2022/4/21 20:15
 * @Version 1.0
 */
public class Leetcode337 {
    HashMap<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null) return 0;

        if(map.containsKey(root)) {
            return map.get(root);
        }

        int rob = root.val +
                (root.left != null ? rob(root.left.left) + rob(root.left.right) : 0) +
                (root.right != null ? rob(root.right.left) + rob(root.right.right) : 0);
        int notRob = rob(root.left) + rob(root.right);

        int max = Math.max(rob, notRob);
        map.put(root, max);
        return max;
    }
}
