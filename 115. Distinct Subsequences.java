/*
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
Example 2:

Input: S = "babgbag", T = "bag"
Output: 5
Explanation:

As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^
*/
class Solution {
    public int numDistinct(String s, String t) {
        int dp[][] = new int[t.length() + 1][s.length() + 1];
        //dp[m+1][n+1] means that S[0..n] contains T[0..m]
        for (int i = 0; i <= s.length(); i++) {
            dp[0][i] = 1;//s[0...n] contains T[/] only 1 time
        }

        //if the current character in S doesn't equal to current character T, then we have the same number of distinct             
        //subsequences as we had without the new character.
        //if the current character in S equal to the current character T, 
        //then the distinct number of subsequences: the number we had before plus the distinct number of subsequences we had with less longer T and less longer S.
        for (int m = 0; m < t.length(); m++) {
            for (int n = 0; n < s.length(); n++) {
                if (s.charAt(n) == t.charAt(m)) {
                    dp[m+1][n+1] = dp[m+1][n] + dp[m][n]; 
                } else {
                    dp[m+1][n+1] = dp[m+1][n];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}