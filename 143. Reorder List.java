/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.
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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        //find middle of the list
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        
        
        //reverse the second part
        ListNode mid = n1;
        ListNode curNode = n1.next;
        while(curNode.next != null){
            ListNode postNode = curNode.next;
            curNode.next = postNode.next;
            postNode.next = mid.next;
            mid.next = postNode;
        }
        //reorder
        n1 = head;
        n2 = mid.next;
        while (n1 != mid){
            mid.next=n2.next;
            n2.next = n1.next;
            n1.next = n2;
            n1 = n2.next;
            n2 = mid.next;
        }
    }
}