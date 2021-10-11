// 230.二叉搜索树中的第k小元素
public class kthSmallest {
    private int count = 0;
    private int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    public void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
        }
        traverse(root.right, k);
    }
}
