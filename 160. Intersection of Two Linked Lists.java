/*
Write a program to find the node at which the intersection of two singly linked lists begins.

Example 1:

Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
Output: Reference of the node with value = 8
Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). 
From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. 
There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        int lengthA = 0;
        int lengthB = 0;
        ListNode A = headA;
        ListNode B = headB;
        while (A.next != null) {
            A = A.next;
            lengthA++;
        }
        while (B.next != null) {
            B = B.next;
            lengthB++;
        }
        
        for (int i = 0; i < (lengthA - lengthB); i++) {
            headA = headA.next;
        }
        for (int i = 0; i < (lengthB - lengthA); i++) {
            headB = headB.next;
        }
        
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}