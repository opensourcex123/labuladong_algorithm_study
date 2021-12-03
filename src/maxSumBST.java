// 1373.二叉搜索子树的最大键值和
public class maxSumBST {
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    // 返回4个值，第0个判断是否为搜索树
    // 第1个记录以root为根的节点中的最小值
    // 第2个记录最大值
    // 第3个记录以root为根的二叉树的所有节点之和
    private int[] traverse(TreeNode root) {
        if (root == null) {
            return new int[] {1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        int[] res = new int[4];
        if (left[0] ==  1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
            res[0] = 1;
            res[1] = Math.min(left[1], root.val);
            res[2] = Math.max(right[2], root.val);
            res[3] = left[3] + right[3] + root.val;
            maxSum = Math.max(maxSum, res[3]);
        } else {
            res[0] = 0;
        }
        return res;
    }
}
