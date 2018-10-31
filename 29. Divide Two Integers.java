/*
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [?231,  231 ? 1]. For the purpose of this problem, assume that your function returns 231 ? 1 when the division result overflows.
 */

class Solution {
    public int divide(int dividend, int divisor) {
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? true: false;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long result = 0;
        while (absDividend >= absDivisor) {
            long tmp = absDivisor, count = 1;
            while (tmp <= absDividend) {
                tmp <<= 1;
                count <<= 1;
            }
            result += count >> 1;
            absDividend -= tmp >> 1; 
        }
        return isNegative ? (int) ~result + 1: result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }
}