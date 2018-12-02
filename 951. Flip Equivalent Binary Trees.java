/*
For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.

A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.

Write a function that determines whether two binary trees are flip equivalent.  The trees are given by root nodes root1 and root2.

 

Example 1:

Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
Output: true
Explanation: We flipped at nodes with values 1, 3, and 5.
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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return nodeEqual(root1, root2);
    }
    
    
    public boolean nodeEqual(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null){
            return true;
        }
        if (node1 == null && node2 != null){
            return false;
        }
        if (node1 != null && node2 == null){
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        if ((nodeEqual(node1.left,node2.left) && nodeEqual(node1.right,node2.right)) || (nodeEqual(node1.left,node2.right) && nodeEqual(node1.right,node2.left))) {
            return true;
        }
        return false;
    }
}