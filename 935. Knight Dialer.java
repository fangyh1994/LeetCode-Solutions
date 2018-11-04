/*
A chess knight can move as indicated in the chess diagram below:

 .           

 

This time, we place our chess knight on any numbered key of a phone pad (indicated above), and the knight makes N-1 hops.  Each hop must be from one key to another numbered key.

Each time it lands on a key (including the initial placement of the knight), it presses the number of that key, pressing N digits total.

How many distinct numbers can you dial in this manner?

Since the answer may be large, output the answer modulo 10^9 + 7.

 

Example 1:

Input: 1
Output: 10
Example 2:

Input: 2
Output: 20
Example 3:

Input: 3
Output: 46
 

Note:

1 <= N <= 5000
 */

class Solution {
    public int knightDialer(int N) {
        int mod = 1000000007;
        if (N == 1) {
            return 10;
        }
        long[][] dp = new long[10][N+1];
        for (int i = 0; i <= 9; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i <= N; i++) {
            dp[1][i] = (dp [6][i-1] + dp[8][i-1])% mod;
            dp[2][i] = (dp [7][i-1] + dp[9][i-1])% mod;
            dp[3][i] = (dp [4][i-1] + dp[8][i-1])% mod;
            dp[4][i] = (dp [3][i-1] + dp[9][i-1] + dp[0][i-1])% mod;
            dp[5][i] = 0;
            dp[6][i] = (dp [1][i-1] + dp[7][i-1] + dp[0][i-1])% mod;
            dp[7][i] = (dp [2][i-1] + dp[6][i-1])% mod;
            dp[8][i] = (dp [1][i-1] + dp[3][i-1])% mod;
            dp[9][i] = (dp [2][i-1] + dp[4][i-1])% mod;
            dp[0][i] = (dp [4][i-1] + dp[6][i-1])% mod;
        }
        long res = 0;
        for (int i = 0; i <= 9; i++) {
            res = (res + dp[i][N])% mod;
        }
        return (int)res%mod;
    }
}