package Tree.BST;

public class LC270_Closest_Binary_Search_Tree_Value {
    //carry on
    public int closestValue(TreeNode root, double target) {
        if (root == null) return -1;
        int closest = root.val;
        TreeNode cur = root;
        while (cur != null) {
            if (Math.abs(cur.val - target) < Math.abs(closest - target)) {
                closest = cur.val;
            }
            if (cur.val < target) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

        return closest;
    }
}
