/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        
        
        ListNode partition = new ListNode(0);//dummy node
        partition.next = head;
        head = partition;
        while (partition.next != null && partition.next.val < x) {
            partition = partition.next;
        }
        ListNode current = partition;
        
        while (current.next != null) {
            if (current.next.val < x) {
                ListNode temp = current.next;
                current.next = current.next.next;
                temp.next = partition.next;
                partition.next = temp;
                partition = partition.next;
                
            } else {
                current = current.next;
            }
        }
        return head.next;
    }
}