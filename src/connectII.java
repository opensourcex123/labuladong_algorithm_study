import java.util.LinkedList;
import java.util.Queue;

// 117.填充每个节点的下一个右侧节点指针II
public class connectII {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> q = new LinkedList<>();
        root.next = null;
        q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            Node last = null;
            for (int i = 0; i < sz; i++) {
                Node node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                if (i != 0) last.next = node;
                last = node;
            }
        }
        return root;
    }
}
