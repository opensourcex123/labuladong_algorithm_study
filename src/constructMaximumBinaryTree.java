// 654.最大二叉树
public class constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int l, int h) {
        if (l > h) return null;
        int index = -1, maxValue = Integer.MIN_VALUE;
        for (int i = l; i <= h; i++) {
            if (maxValue < nums[i]) {
                index = i;
                maxValue = nums[i];
            }
        }
        TreeNode root = new TreeNode(maxValue);
        root.left = build(nums, l, index - 1);
        root.right = build(nums, index + 1, h);
        return root;
    }
}
