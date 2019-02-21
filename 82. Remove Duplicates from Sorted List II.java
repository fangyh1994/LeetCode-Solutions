/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        Map <Integer, Boolean> map = new HashMap<>();
        ListNode node = head;
        map.put(node.val, false);
        while (node.next != null) {
            node = node.next; 
            if (map.containsKey(node.val)) {
                map.put(node.val, true);
            } else {
                map.put(node.val, false);
            }
        }
        node = new ListNode(-1);
        node.next = head;
        ListNode ans = node;
        while (node.next != null) {
            if (map.get(node.next.val) == true) {
                node.next = node.next.next;
            } else {
               node = node.next; 
            } 
        }
        return ans.next;
    }
}