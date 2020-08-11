package Tree.BinaryTree;

public class LC437_Path_SUM_III {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    public int helper(TreeNode root, int sum) {
        int count = 0;
        if (root == null) return 0;
        if (sum == 0) {
            count++;
        }
        count += helper(root.left, sum - root.val);
        count += helper(root.right, sum - root.val);

        return count;
    }
}
