/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n == 0){
            return result;
        }
        helper(result, 0, 0, "", 0, n);
        return result;
    }
    public void helper(List<String> result, int left, int right, String current, int index, int n){
        if (index == 2*n) {
            result.add(current);
            return;
        }
        if (left < n && right < n && left > right){
            String next = current + "(";
            helper (result, left+1, right, next, index+1, n);
            next = current + ")";
            helper (result, left, right+1, next, index+1, n);
        } else if (left < n && right < n && left == right){
            String next = current + "(";
            helper (result, left+1, right, next, index+1, n);
        } else if (left >= n && right < n) {
            String next = current + ")";
            helper (result, left, right+1, next, index+1, n);
        } 
    }
    
}