/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() == 0){
            return false;
        }
        int length = s.length();
        int[] visited = new int[length+1];
        Set<String> set = new HashSet<String>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[1] = 0;
        int start = 0;
        int end = 0;
        while (!queue.isEmpty()){
            start = queue.poll();
            if (visited[start] == 1){
                continue;
            }
            for (end = start + 1; end <= length; end++){
                if (set.contains(s.substring(start, end))){
                    queue.add(end);
                    if (end == length){
                        return true;
                    }
                }
            }
            visited[start] = 1;
        }
        return false;
    }
}