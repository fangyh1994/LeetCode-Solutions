/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 �� n �� 30, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

 

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"

 */

class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else {
            String s = countAndSay(n-1);
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                int count = 1;
                Character c = s.charAt(i);
                while ( i < s.length() - 1 && s.charAt(i+1) == s.charAt(i) ) {
                    i++;
                    count++;
                }
                res += Integer.toString(count);
                res += c;
            }
            return res;
        }
    }
}