package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Verge
 * @Date 2022/2/10 20:18
 * @Version 1.0
 */
public class JZOffer36 {
    public static void main(String[] args) {
        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(3);
        JZOffer36 jzOffer36 = new JZOffer36();
        jzOffer36.treeToDoublyList(node);
    }

    List<Node> list = new ArrayList<>();
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        recur(root);

        Node res = list.get(0);

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
        }

        for (int i = list.size() - 1; i > 0 ; i--) {
            list.get(i).left = list.get(i - 1);
        }

        list.get(list.size() - 1).right = list.get(0);
        list.get(0).left = list.get(list.size() - 1);


        return res;
    }

    public void recur(Node cur) {
        if (cur == null) return;
        recur(cur.left);
        list.add(cur);
        recur(cur.right);
    }
}
