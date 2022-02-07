package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Verge
 * @Date 2022/2/7 19:19
 * @Version 1.0
 */
public class JZOffer34 {
    public static void main(String[] args) {
        JZOffer34 jzOffer34 = new JZOffer34();
        TreeNode node = new TreeNode(-2);
        node.left = null;
        node.right = new TreeNode(-3);
        System.out.println(jzOffer34.pathSum(node, -5));
    }

    List<List<Integer>> res = new ArrayList<>();
    int target = -1;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        this.target = target;
        recur(root, 0, new ArrayList<>());
        return res;
    }

    public void recur(TreeNode node, int distance, List<Integer> list) {
        list.add(node.val);
        distance += node.val;
        if (node.left == null && node.right == null && distance == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (node.left != null) recur(node.left, distance, list);
        if (node.right != null) recur(node.right, distance, list);
    }
}
