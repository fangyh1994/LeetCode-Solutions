/*
Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
*/

class Solution {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean first_match = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0)=='.'));
        if (p.length() > 1 && p.charAt(1) == '*'){
            if (first_match){
                return isMatch(s, p.substring(2)) || isMatch(s.substring(1), p);
            } else {
                return isMatch(s, p.substring(2));
            }
        } else {
            if (first_match){
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }
    }
}

/* Solution 2: use DP to cache the intermediate results.*/