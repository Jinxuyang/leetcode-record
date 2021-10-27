package tree;

import java.util.Arrays;

/**
 * @Author Verge
 * @Date 2021/10/27 19:34
 * @Version 1.0
 */
public class JZOffer07 {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        JZOffer07 jzOffer07 = new JZOffer07();
        jzOffer07.buildTree(preorder, inorder);
    }

    /**
     * 思路：前序遍历的第一个节点是根节点，通过这个条件可以在中序遍历的结果中找到这颗树的左右子树，根节点将中序遍历结果一分为二，左边为左子树右边为右子树。
     *      对于左右子树可以采用完全相同的方法处理，这里考虑使用递归进行处理
     *      使用递归处理第一步先确定结束条件，这个问题的结束条件就是，当前序和中序遍历结果大小为1时说明这个节点是一个叶子节点，不需要继续进行地柜
     *      第二步是通过二叉树中序和前序遍历的特性，将问题划分为一个个子问题
     *      注意：人脑难以模拟递归的过程
     *      如果一个问题 A 可以分解为若干子问题 B、C、D，你可以假设子问题 B、C、D 已经解决，在此基础上思考如何解决问题 A。
     *      而且，你只需要思考问题 A 与子问题 B、C、D 两层之间的关系即可，不需要一层一层往下思考子问题与子子问题，子子问题与子子子问题之间的关系。
     *      屏蔽掉递归细节，这样子理解起来就简单多了。
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 1 && inorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int root = preorder[0];
        int mid = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (root == inorder[i]) {
                mid = i;
                break;
            }
        }

        int[] inorderL = Arrays.copyOfRange(inorder, 0, mid);
        int[] inorderR = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
        int[] preorderL = Arrays.copyOfRange(preorder, 1, inorderL.length + 1);
        int[] preorderR = Arrays.copyOfRange(preorder, inorderL.length + 1, preorder.length);

        TreeNode treeNode = new TreeNode(root);
        treeNode.left = buildTree(preorderL, inorderL);
        treeNode.right = buildTree(preorderR, inorderR);

        return treeNode;
    }

}
