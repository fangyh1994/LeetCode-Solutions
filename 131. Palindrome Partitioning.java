/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
 */

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<>();
        helper (res, temp, s, 0);
        return res;
    }
    
    public void helper(List<List<String>> res, List<String> temp, String s, int index) {
        if (index == s.length()){
            res.add(new ArrayList<>(temp)); //has to use new keyword, otherwise temp is only an address of that List)
        }
        for (int i = index + 1; i < s.length()+1; i++) {
            if (isPalindrome(s.substring(index, i))) {
                temp.add(s.substring(index, i));
                helper (res, temp, s, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s) {
        for (int i = 0; i <= s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}