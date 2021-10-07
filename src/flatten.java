// 114.二叉树展开为链表
public class flatten {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = left;
        root.left = null;

        TreeNode p = root;
        while (p.right != null) p = p.right;
        p.right = right;
    }
}
