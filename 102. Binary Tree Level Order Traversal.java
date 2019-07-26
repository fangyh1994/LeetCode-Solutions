/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        helper(ans, root, 0);
        return ans;
    }
    
    public void helper(List<List<Integer>> ans, TreeNode root, int height) {
        if (height >= ans.size()) {
            ans.add(new ArrayList<Integer>());
        }
        ans.get(height).add(root.val);
        if (root.left != null) {
            helper(ans, root.left, height + 1);
        }
        if (root.right != null) {
            helper(ans, root.right, height + 1);
        }
    }
}