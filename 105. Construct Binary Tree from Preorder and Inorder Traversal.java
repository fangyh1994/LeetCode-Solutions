/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build (preorder,inorder,0,preorder.length - 1,0,inorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int[] inorder, int prelo, int prehi, int inlo, int inhi){
        if ((prehi < prelo)||(inhi < inlo)){
            return null;
        }
        TreeNode root = new TreeNode(preorder[prelo]);
        int index = 0;
        for (int i = inlo; i <= inhi; i++){
            if (inorder[i] == preorder[prelo]){
                index = i;
            }
        }
        int leftsize = index - inlo;
        root.left = build(preorder, inorder, prelo + 1, prelo + leftsize, inlo, index - 1);
        root.right = build(preorder, inorder, prelo + 1 + leftsize, prehi, index + 1, inhi);
        return root;
    }
}