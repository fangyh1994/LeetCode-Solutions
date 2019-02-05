/*
Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.

Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

(As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)

 

Example 1:

Input: [0,1,2,3,4,3,4]
Output: "dba"
Example 2:

Input: [25,1,3,1,3,0,2]
Output: "adz"
Example 3:

Input: [2,2,1,null,1,0,null,0]
Output: "abc"

Note:

The number of nodes in the given tree will be between 1 and 1000.
Each node in the tree will have a value between 0 and 25.
 
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
    public String smallestFromLeaf(TreeNode root) {
        if (root == null) {
            return "";
        }
        String Alphabet = "abcdefghijklmnopqrstuvwxyz";
        String answer = "";
        if (root.left == null && root.right == null) {
            answer += Alphabet.charAt(root.val);
        } else if (root.left == null) {
            
            String r = smallestFromLeaf(root.right);
            answer = r + Alphabet.charAt(root.val);
            /*
            if (r.charAt(0)-'a' < root.val) {
                answer = r + Alphabet.charAt(root.val);
            } else {
                answer += Alphabet.charAt(root.val);
            }
            */
        } else if (root.right == null) {
            
            String l = smallestFromLeaf(root.left);
            answer = l + Alphabet.charAt(root.val);
            /*
            if (l.charAt(0)-'a' < root.val) {
                answer = l + Alphabet.charAt(root.val);
            } else {
                answer += Alphabet.charAt(root.val);
            }
            */
        } else {
            String l = smallestFromLeaf(root.left);
            String r = smallestFromLeaf(root.right);
            if (compare(l,r)) {
                answer = l + Alphabet.charAt(root.val);
            } else {
                answer = r + Alphabet.charAt(root.val);
            }
        }
        return answer;
    }
    
    private boolean compare (String A, String B) {
                for (int i = 0; i < Math.min(A.length(), B.length()); i++) {
            if ( (A.charAt(i) - B.charAt(i) ) == 0){
                continue;
            } else {
                if ( (A.charAt(i) - B.charAt(i) ) < 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        if (A.length() < B.length()) {
            return true;
        } else {
            return false;
        }
    }
}