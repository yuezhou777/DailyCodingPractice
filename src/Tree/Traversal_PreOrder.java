package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal_PreOrder {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                res.add(root.val);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }

        return res;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> list, TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        helper(list, root.left);
        helper(list, root.right);
    }
}
