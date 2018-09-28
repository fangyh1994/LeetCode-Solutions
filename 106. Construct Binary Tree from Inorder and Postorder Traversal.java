/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build (inorder,postorder,0,inorder.length - 1,0,postorder.length - 1);
    }
    
    private TreeNode build(int[] inorder, int[] postorder, int inlo, int inhi, int postlo, int posthi){
        if ((inhi < inlo)||(posthi < postlo)){
            return null;
        }
        TreeNode root = new TreeNode(postorder[posthi]);
        int index = 0;
        for (int i = inlo; i <= inhi; i++){
            if (inorder[i] == postorder[posthi]){
                index = i;
            }
        }
        int leftsize = index - inlo;
        root.left = build(inorder, postorder, inlo, index - 1, postlo, postlo + leftsize - 1);
        root.right = build(inorder, postorder, index + 1, inhi, postlo + leftsize, posthi - 1);
        return root;
    }

}