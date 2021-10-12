// 是否是合法的二叉搜索树
public class isValidBST {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }

    public boolean isBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;

        if (max != null && root.val >= max.val) return false;
        if (min != null && root.val <= min.val) return false;

        return isBST(root.left, min, root) && isBST(root.right, root, max);
    }
}
