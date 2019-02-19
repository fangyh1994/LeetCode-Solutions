/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (findParent(root, x) != findParent(root, y) && findDepth(root, x) == findDepth(root, y)) {
            return true;
        }
        return false;
    }
    
    private int findDepth (TreeNode root, int x) {
        if (root == null) {
            return -1;
        }
        if (root.val == x) {
            return 0;
        }
        int left = findDepth(root.left, x);
        int right = findDepth(root.right, x);
        if (left == -1 && right == -1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }
    
    private int findParent (TreeNode root, int x) {
        if (root == null) {
            return -1;
        }
        int left = -1;
        if (root.left != null) {
            if (root.left.val == x) {
                return root.val;
            }
            left = findParent(root.left, x);
        }
        int right = -1;
        if (root.right != null) {
            if (root.right.val == x) {
                return root.val;
            }
            right = findParent(root.right, x);
        }
        
        return Math.max(left, right);
    }
}