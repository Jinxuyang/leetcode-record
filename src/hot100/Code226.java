package hot100;

/**
 * @Author Verge
 * @Date 2022/4/6 19:37
 * @Version 1.0
 */
public class Code226 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert(TreeNode root) {
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.right);
        invert(root.left);
    }
}
