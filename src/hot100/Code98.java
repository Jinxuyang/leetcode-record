package hot100;

/**
 * @Author Verge
 * @Date 2022/3/29 21:03
 * @Version 1.0
 */
public class Code98 {
    TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (!isValidBST(root.left)) return false;
        if (pre != null) {
            if (pre.val >= root.val) return false;
        }
        pre = root;
        return isValidBST(root.right);
    }
}
