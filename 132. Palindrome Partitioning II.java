/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/
class Solution {
    public int minCut(String s) {
        
        char[] c = s.toCharArray();
        int size = c.length;
        int[] cut = new int[size]; //dp array, minimum cut of s[0,i]
        boolean[][] isPal = new boolean[size][size]; //s[i:j] is a palindrome;

        for(int i = 0; i < size; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(c[j] == c[i] && (j + 1 > i - 1 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;  
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[size - 1];
    }
}