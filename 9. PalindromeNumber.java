/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
*/

//time complexityO(n^2)
class Solution {
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        if (x%10 == 0 && x!=0){
            return false;
        }
        int xcopy = x;
        int rev = 0;
        while(xcopy!=0){
            rev = 10*rev + xcopy%10;
            xcopy = (xcopy - xcopy%10)/10;
        }
        if (x == rev){
            return true;
        }
        return false;
    }
}