/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
*/
class Solution {
    public int numTrees(int n) {
        int [] ans = new int[n+1];
        ans[0] = 1;
        ans[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                ans[i] += ans[j-1]*ans[i-j];  
            }
        }
        return ans[n];
    }
}