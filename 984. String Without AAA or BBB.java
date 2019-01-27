/*
Given two integers A and B, return any string S such that:

S has length A + B and contains exactly A 'a' letters, and exactly B 'b' letters;
The substring 'aaa' does not occur in S;
The substring 'bbb' does not occur in S.
 

Example 1:

Input: A = 1, B = 2
Output: "abb"
Explanation: "abb", "bab" and "bba" are all correct answers.
Example 2:

Input: A = 4, B = 1
Output: "aabaa"
 

Note:

0 <= A <= 100
0 <= B <= 100
It is guaranteed such an S exists for the given A and B.
*/

class Solution {
    public String strWithout3a3b(int A, int B) {
        return strWithout3char(A, B, "");
    }
    
    public String strWithout3char(int A, int B, String temp) {
        if (A > B) {
            if (isValid(temp+"a")) {
                return strWithout3char(A-1, B, temp+"a");
            } else {
                return strWithout3char(A, B-1, temp+"b");
            }
        } else if (B > A){
            if (isValid(temp+"b")) {
                return strWithout3char(A, B-1, temp+"b");
            } else {
                return strWithout3char(A-1, B, temp+"a");
            }
        } else{
            if (A == 0) {
                return temp;
            } else {
                if (isValid(temp+"a")) {
                    return strWithout3char(A-1, B, temp+"a");
                } else {
                    return strWithout3char(A, B-1, temp+"b");
                }
            }
        }
    }
    
    public boolean isValid(String str) {
        int l = str.length();
        if (l < 3) {
            return true;
        } else {
            if (str.charAt(l-1) == str.charAt(l-2) && str.charAt(l-2) == str.charAt(l-3)) {
                return false;
            } else {
                return true;
            }
        }
    }
}