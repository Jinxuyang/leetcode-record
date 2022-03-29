package hot100;

/**
 * @Author Verge
 * @Date 2022/3/29 21:31
 * @Version 1.0
 */
public class Code101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return is(root.left, root.right);
    }

    public boolean is (TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;

        return is(left.right, right.left) && is(left.left, right.right);
    }
}
