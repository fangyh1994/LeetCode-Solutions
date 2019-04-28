/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTreesRange(1,n);
    }
    
    private List<TreeNode> generateTreesRange(int a, int b) {
        List<TreeNode> ans = new ArrayList<>();
        if (a > b) {
            ans.add(null);
            return ans;
        }
        //when node i is the root, [a,i-1] as left tree, [i+1, b] as right tree;
        for (int i = a; i <= b; i++) {
            List<TreeNode> leftTree = new ArrayList<>();
            List<TreeNode> rightTree = new ArrayList<>();
            leftTree = generateTreesRange(a, i - 1);
            rightTree = generateTreesRange(i + 1, b);
            for (int j = 0; j < leftTree.size(); j++) {
                for (int k = 0; k < rightTree.size(); k++) {
                    TreeNode tree = new TreeNode(i);
                    tree.left = leftTree.get(j);
                    tree.right = rightTree.get(k);
                    ans.add(tree);
                }
            }
        }
        return ans;
    }
}