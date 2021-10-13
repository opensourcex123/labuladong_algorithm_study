import java.util.LinkedList;
import java.util.List;

// 95.不同的二叉搜索树II
public class generateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<>();
        return build(1, n);
    }

    public List<TreeNode> build(int low, int high) {
        List<TreeNode> res = new LinkedList<>();

        if (low > high) res.add(null);

        for (int mid = low; mid <= high; mid++) {
            List<TreeNode> leftTree = build(low, mid - 1);
            List<TreeNode> rightTree = build(mid + 1, high);
            for (TreeNode left: leftTree) {
                for (TreeNode right: rightTree) {
                    TreeNode root = new TreeNode(mid);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
