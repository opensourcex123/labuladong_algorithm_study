// 700.二叉搜索树中的搜索
public class searchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        return val > root.val ? searchBST(root.right, val) : searchBST(root.left, val);
    }
}
