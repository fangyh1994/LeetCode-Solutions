/*
Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

Return the intersection of these two interval lists.

(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  
The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  
For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
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
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        if (A.length == 0 || B.length == 0) {
            return new Interval[0];
        }
        int pointerA = 0;
        int pointerB = 0;
        Interval[] answer = new Interval[A.length + B.length];
        int currentIndex = 0;
        while (pointerA < A.length && pointerB < B.length) {
            if (Math.max(A[pointerA].start, B[pointerB].start) <= Math.min(A[pointerA].end, B[pointerB].end)) {
                answer[currentIndex] = findInterval(A[pointerA], B[pointerB]);
                currentIndex++;
            }
            if (A[pointerA].end > B[pointerB].end) {
                pointerB++;
            } else {
                pointerA++;
            }
        }
        
        //copy answer to finalAnswer
        Interval[] finalAnswer = new Interval[currentIndex];
        for (int i = 0; i < currentIndex; i++) {
            finalAnswer[i] = answer[i];
        }
        return finalAnswer;
    }
    
    private Interval findInterval(Interval A, Interval B) {
        return new Interval (Math.max(A.start, B.start), Math.min(A.end, B.end));
    }
}