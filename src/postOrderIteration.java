import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 二叉树迭代解法，以后序遍历为例
public class postOrderIteration {
    Stack<TreeNode> stk = new Stack<>();

    public List<Integer> postOrderTraverse(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        // 特殊节点，记录上一次遍历的节点
        TreeNode visited = new TreeNode(-1);

        pushLeftBranch(root);
        while (!stk.isEmpty()) {
            TreeNode p = stk.peek();

            if ((p.left == null || p.left == visited) && p.right != visited) {
                // 确保左子树遍历完成，右子树尚未遍历
                // 中序代码编写位置
                pushLeftBranch(p.right);
            }

            if (p.right == null || p.right == visited) {
                // 确保右子树已被遍历
                // 后序遍历代码位置
                postOrder.add(p.val);
                visited = stk.pop();
            }
        }
        return postOrder;
    }

    private void pushLeftBranch(TreeNode node) {
        while (node != null) {
            // 前序遍历代码位置
            stk.push(node);
            node = node.left;
        }
    }
}
