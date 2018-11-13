/*
For some fixed N, an array A is beautiful if it is a permutation of the integers 1, 2, ..., N, such that:

For every i < j, there is no k with i < k < j such that A[k] * 2 = A[i] + A[j].

Given N, return any beautiful array A.  (It is guaranteed that one exists.)

 

Example 1:

Input: 4
Output: [2,1,4,3]
Example 2:

Input: 5
Output: [3,1,2,5,4]
 

Note:

1 <= N <= 1000
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
    public int[] beautifulArray(int N) {
        int[] answer = new int[N];
        if (N == 1) {
            answer[0] = 1;
        } else {
            int index = 0;
            for (int x: beautifulArray((N+1)/2) ) {
                //odd number: left side
                answer [index] = 2*x - 1;
                index++;
            }
            
            for (int x: beautifulArray(N/2)) {
                //even number: right side
                answer [index] = 2*x;
                index++;
            }
        }
        return answer;
    }
}