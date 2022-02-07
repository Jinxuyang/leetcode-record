package tree;

import java.util.Arrays;

/**
 * @Author Verge
 * @Date 2022/2/6 20:51
 * @Version 1.0
 */
public class JZOffer33 {
    public static void main(String[] args) {
        JZOffer33 j =  new JZOffer33();
        int[] x = {1,3,2,6,5};
        System.out.println(j.verifyPostorder(x));
    }
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0 || postorder.length == 1) return true;
        int lastIndex = postorder.length - 1;
        int root = postorder[lastIndex];
        int midIndex = lastIndex;
        for (int i = 0; i < lastIndex; i++) {
            if (midIndex == lastIndex && root < postorder[i]) {
                midIndex = i;
            }
            if (midIndex != lastIndex && root > postorder[i]) return false;
        }

        return verifyPostorder(Arrays.copyOfRange(postorder, 0, midIndex))
                && verifyPostorder(Arrays.copyOfRange(postorder,midIndex, lastIndex));
    }
}
