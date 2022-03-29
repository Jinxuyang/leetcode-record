package hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Verge
 * @Date 2022/3/29 19:20
 * @Version 1.0
 */
public class Code105 {
    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        Code105 code105 = new Code105();
        TreeNode treeNode = code105.buildTree1(pre, in);
        System.out.println(treeNode);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        int root = preorder[0];
        TreeNode treeRoot = new TreeNode(root);

        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                index = i;
                break;
            }
        }

        int[] LIn = Arrays.copyOfRange(inorder, 0, index);
        int[] LPre = Arrays.copyOfRange(preorder, 1, 1 + LIn.length);
        treeRoot.left = buildTree(LPre, LIn);

        int[] RIn = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] RPre = Arrays.copyOfRange(preorder, 1 + LPre.length, preorder.length);
        treeRoot.right = buildTree(RPre, RIn);

        return treeRoot;
    }

    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int inL, int inR, int preL,int preR) {
        if (preR <= preL) return null;
        int root = preorder[preL];
        TreeNode treeRoot = new TreeNode(root);

        int index = map.get(root);


        treeRoot.left = build(preorder, inorder, inL, index, 1 + preL, 1 + preL + index - inL);
        treeRoot.right = build(preorder, inorder, index + 1, inR + 1, 1 + preL + index - inL, 1 + preL + index - inL + inR - index);

        return treeRoot;
    }
}
