package tree;

import java.util.ArrayList;
import java.util.List;

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
}
