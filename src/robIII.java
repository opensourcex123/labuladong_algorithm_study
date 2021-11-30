import java.util.HashMap;
import java.util.Map;

// 337.打家劫舍III
public class robIII {
    Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);
        int do_it = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right)) + (root.right == null ? 0 : rob(root.right.right) + rob(root.right.left));

        int not_do = rob(root.left) + rob(root.right);

        int res = Math.max(do_it, not_do);

        memo.put(root, res);
        return res;
    }
}
