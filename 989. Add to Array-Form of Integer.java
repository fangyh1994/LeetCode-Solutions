/*
For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  For example, if X = 1231, then the array form is [1,2,3,1].

Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.

 

Example 1:

Input: A = [1,2,0,0], K = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234
Example 2:

Input: A = [2,7,4], K = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455
Example 3:

Input: A = [2,1,5], K = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021
Example 4:

Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
Output: [1,0,0,0,0,0,0,0,0,0,0]
Explanation: 9999999999 + 1 = 10000000000
 */
class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> arrayFormK = new ArrayList<>();
        while (K != 0) {
            int digit = K % 10;
            arrayFormK.add(0, digit);
            K = (K - digit)/10;
        }

        List<Integer> ans = new ArrayList<>();
        add(ans, A, arrayFormK);
        return ans;
    }
    
    private void add(List<Integer> ans, int[] A, List<Integer> arrayFormK) {
        int carry = 0;
        int i = 0;
        while (i < A.length || i < arrayFormK.size()) {
            int digit = 0;
            digit += carry;
            if (i < A.length) {
                digit += A[A.length - 1 - i];
            }
            if (i < arrayFormK.size()) {
                digit += arrayFormK.get(arrayFormK.size() - 1 - i);
            }
            carry = digit / 10;
            digit = digit % 10;
            ans.add(0, digit);
            i++;
        }
        if (carry == 1) {
            ans.add(0, carry);
        }
    }
}