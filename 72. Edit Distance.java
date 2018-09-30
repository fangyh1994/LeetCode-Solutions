/*
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
*/
/*
 dp[i][j]��ʾ���ǣ����ַ���1��i��λ��ת�����ַ���2��j��λ�ã�����Ҫ�����ٲ�����
     1,�ַ����е��ַ����: dp[i][j] = dp[i - 1][j - 1]
     2,�ַ����е��ַ�����:
         insert: dp[i][j] = dp[i][j - 1] + 1;
         replace: dp[i][j] = dp[i - 1][j - 1] + 1;
         delete: dp[i][j] = dp[i - 1][j] + 1;
           a  b  c  d
        0  1  2  3  4
     a  1  0  1  2  3
     e  2  1  1  2  3
     f  3  2  2  2  3
     time : O(m * n)
     space : O(m * n)
*/
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int [][] dp = new int [m+1][n+1];
        for (int i = 0; i < m + 1; i++){
            dp[i][0] = i;
        }
        for (int i = 0; i < n + 1; i++){
            dp[0][i] = i;
        }
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (word1.charAt(i) == word2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                } else {
                    dp[i+1][j+1] = Math.min(Math.min(dp[i][j], dp[i][j+1]), dp[i+1][j]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}