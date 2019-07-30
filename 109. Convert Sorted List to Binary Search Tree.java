/*
09. Convert Sorted List to Binary Search Tree
Medium

1109

68

Favorite

Share
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    private List <Integer> list;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        this.list = new ArrayList<Integer>();
        while (head != null) {
            this.list.add(head.val);
            head = head.next;
        }
        return sortedArrayToBST(0, list.size() - 1);
    }
    
    public TreeNode sortedArrayToBST(int low, int hi) {
        if (low > hi) {
            return null;
        }
        int mid = (hi - low) / 2 + low;
        TreeNode node = new TreeNode(this.list.get(mid));
        node.left = sortedArrayToBST(low, mid - 1);
        node.right = sortedArrayToBST(mid + 1, hi);
        return node;
    }
}