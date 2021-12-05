// 222.完全二叉树的节点个数
public class countNodes {
    public int countNodes(TreeNode root) {
        TreeNode l = root;
        TreeNode r = root;
        int hl = 0, hr = 0;
        if (root == null) return 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }

        // 由于完全二叉树中必包含满二叉树，所以可以用满二叉树的计算方法来降低时间复杂度
        if (hl == hr) {
            return (int)Math.pow(2, hl) - 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
