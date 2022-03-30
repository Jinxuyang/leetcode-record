package hot100;

/**
 * @Author Verge
 * @Date 2022/3/30 13:36
 * @Version 1.0
 */
public class Code114 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        Code114 code114 = new Code114();
        code114.flatten(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }

    }
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        recur(root);
        while (root != null) {
            root.right = root.left;
            root.left = null;
            root = root.right;
        }
    }

    public void recur(TreeNode root) {
        if (root == null) return;
        if (pre == null) {
            pre = root;
        }
        else {
            pre.left = root;
            pre = pre.left;
        }
        recur(root.left);
        recur(root.right);
    }


}
