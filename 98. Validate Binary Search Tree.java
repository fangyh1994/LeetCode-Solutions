/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return true;
        }
        inOrderTraversal(root, list);
        int val1 = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= val1) {
                return false;
            }
            val1 = list.get(i);
        }
        return true;
    }
    
    public void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root.left != null) {
            inOrderTraversal(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            inOrderTraversal(root.right, list);
        }
    }
}