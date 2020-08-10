package Tree.BST;

public class TreeNode { //generic
    int val;
    TreeNode left;
    TreeNode right;
    //TreeNode mid;
    //TreeNode parent;
    public TreeNode() {}
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
