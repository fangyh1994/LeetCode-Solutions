/*
You have d dice, and each die has f faces numbered 1, 2, ..., f.

Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so the sum of the face up numbers equals target.

 

Example 1:

Input: d = 1, f = 6, target = 3
Output: 1
Explanation: 
You throw one die with 6 faces.  There is only one way to get a sum of 3.
Example 2:

Input: d = 2, f = 6, target = 7
Output: 6
Explanation: 
You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
Example 3:

Input: d = 2, f = 5, target = 10
Output: 1
Explanation: 
You throw two dice, each with 5 faces.  There is only one way to get a sum of 10: 5+5.
Example 4:

Input: d = 1, f = 2, target = 3
Output: 0
Explanation: 
You throw one die with 2 faces.  There is no way to get a sum of 3.
Example 5:

Input: d = 30, f = 30, target = 500
Output: 222616187
Explanation: 
The answer must be returned modulo 10^9 + 7.
*/
class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int module = 1000000007;
        int[][] dp = new int[d + 1][target + 1]; ;
        //dp[i][j] means how many ways can i dices sum up to j
        /* only one dice */
        for(int i = 1; i <= f && i <= target; i++) 
            dp[1][i] = 1;
        
        //how many possibility can i([2,d]) dices sum up to j;
        for(int i = 2; i <= d; i++) {
            for(int j = 1; j<= target; j++) {
                if(j > i * f) {
                   continue;          
                } else {
                    for(int k = 1; k <= f && k <= j ; k++) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % module; 
                    }
                }
            }
        }
        return dp[d][target];
    }
}