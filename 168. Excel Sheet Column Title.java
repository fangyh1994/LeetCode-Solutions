/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"
*/
class Solution {
    public String convertToTitle(int n) {
        String list = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String str = "";
        int remain = 0;
        while(n > 26) {
            remain = n % 26;
            n = n/26;
            if (remain == 0){
                remain = 26;
                n--;
            }
            str = list.substring(remain - 1,remain) + str;
        }
        str = list.substring(n - 1, n) + str;
        return str;
    }
}