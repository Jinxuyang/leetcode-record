package tree;

/**
 * @Author Verge
 * @Date 2022/1/10 21:44
 * @Version 1.0
 */
public class JZOffer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null || A == null) return false;
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null) return false;

        if (A.val == B.val) {
            return recur(A.left, B.left) && recur(A.right, B.right);
        } else {
            return false;
        }
    }
}
