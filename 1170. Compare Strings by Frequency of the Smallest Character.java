/*
Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.

Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.

 

Example 1:

Input: queries = ["cbd"], words = ["zaaaz"]
Output: [1]
Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
Example 2:

Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
Output: [1,2]
Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
*/
class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int[] count = new int[words.length];
        
        for (int i = 0; i < words.length; i++) {
            count[i] = numFrequency(words[i]);
        }
        
        for (int i = 0; i < queries.length; i++) {
            int numQuery = numFrequency(queries[i]);
            for (int j = 0; j < count.length; j++) {
                if(numQuery < count[j]){
                    ans[i]++;
                }
            }
        }
        return ans;
        
        
    }
    
    private int numFrequency(String str) {
        char ch = 'z';
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < ch) {
                ch = str.charAt(i);
            }
        }

        int numOfChar = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                numOfChar++;
            }
        }
        return numOfChar;
    }
}