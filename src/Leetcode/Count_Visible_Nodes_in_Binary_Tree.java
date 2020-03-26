package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class Count_Visible_Nodes_in_Binary_Tree {
    public List<Integer> count(TreeNode root){
        List<Integer> res = new ArrayList<>();
        dfs(res, root, Integer.MIN_VALUE);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root, int max) {
        if (root == null) return;
        if (root.val > max) {
            res.add(root.val);
            max = root.val;
        }
        dfs(res, root.left, max);
        dfs(res, root.right, max);
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
       this.val = val;
       this.left = null;
       this.right = null;
    }
}

//In a binary tree, if in the path from root to the node A, there is no node with greater value than A’s, this node A is visible. We need to count the number of visible nodes in a binary tree.
//
//Example 1:
//
//Input:
//        5
//     /     \
//   3        10
//  /  \     /
//20   21   1
//
//Output: 4
//Explanation: There are 4 visible nodes: 5, 20, 21, and 10.
//Example 2:
//
//Input:
//  -10
//	\
//	-15
//	   \
//	   -1
//
//Output: 2
//Explanation: Visible nodes are -10 and -1.
