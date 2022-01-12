package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author Verge
 * @Date 2022/1/12 19:09
 * @Version 1.0
 */
public class JZOffer28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null || root.left.val != root.right.val) return false;
        return recur(root.left, root.right);
    }

    public boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;

        if (equal(L.left, R.right) && equal(L.right, R.left)) {
            return recur(L.left, R.right) && recur(L.right, R.left);
        }
        else {
            return false;
        }
    }

    public boolean equal(TreeNode A, TreeNode B) {
        if ((A == null && B != null) || (A != null && B == null)) {
            return false;
        } else if (A == null && B == null){
            return true;
        } else {
            return A.val == B.val;
        }
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        return recur1(root.left, root.right);
    }

    public boolean recur1(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return recur1(L.left, R.right) && recur1(L.right, R.left);
    }


}
