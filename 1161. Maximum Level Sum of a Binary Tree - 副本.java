/*
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level X such that the sum of all the values of nodes at level X is maximal.

Example 1:

Input: [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
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
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 1;
        }
        List<Integer> levelSum = new ArrayList<Integer>();
        helper(root, levelSum, 1);
        int ans = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < levelSum.size(); i++) {
            if (levelSum.get(i) > max) {
                ans = i + 1;
                max = levelSum.get(i);
            }
        }
        return ans;
    }
    
    public void helper(TreeNode node, List<Integer> list, int level) {
        if (list.size() < level) {
            //list.add(level - 1, node.val);
            list.add(node.val);
        } else {
            list.set(level - 1, list.get(level - 1) + node.val);
        }
        if (node.left != null) {
            helper(node.left, list, level + 1);
        }
        if (node.right != null) {
            helper(node.right, list, level + 1);
        }
    }
}