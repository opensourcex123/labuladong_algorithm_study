import java.util.LinkedList;
import java.util.Queue;

// 297.二叉树的序列化与反序列化
public class Codec {
    String SEQ = ",";
    String NULL = "#";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        traverse(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList();
        for (String s : data.split(",")) {
            nodes.offer(s);
        }
        return detraverse(nodes);
    }

    private void traverse(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEQ);
            return;
        }

        sb.append(root.val).append(SEQ);
        traverse(root.left, sb);
        traverse(root.right, sb);
    }

    private TreeNode detraverse(Queue<String> nodes) {
        if (nodes.isEmpty()) return null;

        String first = nodes.poll();
        if (first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = detraverse(nodes);
        root.right = detraverse(nodes);
        return root;
    }
}
