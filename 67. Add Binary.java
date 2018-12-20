/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
*/
class Solution {
    public String addBinary(String a, String b) {
        if ((a.length() > b.length())) {
            return addBinary(b, a);
        }
        int length = b.length();
        while (a.length() != length) {
            a = "0" + a;
        }
        
        int carry = 0;
        String res = "";
        for (int i = length - 1; i >= 0; i--) {
            int numa = a.charAt(i) - '0';
            int numb = b.charAt(i) - '0';
            int sum = numa + numb + carry;
            if (sum == 0) {
                carry = 0;
                res = "0" + res;
            } else if (sum == 1) {
                carry = 0;
                res = "1" + res;
            } else if (sum == 2) {
                carry = 1;
                res = "0" + res;
            } else if (sum == 3) {
                carry = 1;
                res = "1" + res;
            }
        }
        if (carry == 1){res = "1" + res;}
        return res;
    }
}