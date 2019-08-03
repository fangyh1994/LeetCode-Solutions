/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> currPath = new ArrayList<Integer>();
        if (root == null) {
            return ans;
        }
        
        helper(ans, currPath, root, sum);
        return ans;
    }
    
    public void helper (List<List<Integer>> ans, List<Integer> currPath, TreeNode root, int sum) {
        currPath.add(root.val);
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                ans.add(new ArrayList<Integer>(currPath));
            }  
        }
        if (root.left != null) {
            helper (ans, currPath, root.left, sum - root.val);
        }
        
        if (root.right != null) {
            helper (ans, currPath, root.right, sum - root.val);
        }
        currPath.remove(currPath.size() - 1);
    }
}