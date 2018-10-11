/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        Queue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2){
                if (n1.val > n2.val){
                    return 1;
                } else if (n1.val == n2.val){
                    return 0;    
                } else if (n1.val < n2.val){
                    return -1;
                }
                return 0;
            }
        });
        ListNode result = new ListNode(0);
        ListNode current = result;
        for (int i = 0; i < lists.length; i++){
            if (lists[i] != null){
                pq.add(lists[i]);
            }
        }
        while (!pq.isEmpty()){
            current.next = pq.poll();
            current = current.next;
            if (current.next != null){
                pq.add(current.next);
            }
            
        }
        return result.next;  
    }
}