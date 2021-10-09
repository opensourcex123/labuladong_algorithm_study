import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

// 652.寻找重复的子树
public class findDuplicateSubtrees {
    HashMap<String, Integer> memo = new HashMap<>();
    LinkedList<TreeNode> res = new LinkedList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    public String traverse(TreeNode root) {
        if (root == null) return "#";

        String left = traverse(root.left);
        String right = traverse(root.right);

        String sb = left + "," + right + "," + root.val;
        int freq = memo.getOrDefault(sb, 0);
        if (freq == 1) res.add(root);
        memo.put(sb, freq + 1);
        return sb;
    }
}
