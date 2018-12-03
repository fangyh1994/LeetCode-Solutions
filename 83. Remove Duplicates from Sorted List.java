/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3
*/
public class ListNode {
    public int x;
    public ListNode next;
    public ListNode (int x) {
        val = x;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // if (head == null) {
        //     return head;
        // }
        // Set <Integer> set = new HashSet<>();
        // ListNode node = head;
        // set.add(node.val);
        // while (node.next != null) {
        //     if (set.contains(node.next.val)) {
        //         node.next = node.next.next;
        //     } else {
        //        set.add(node.next.val);
        //        node = node.next; 
        //     } 
        // }
        // return head;
        if (head == null) {
            return head;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val){
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}