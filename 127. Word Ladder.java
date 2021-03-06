/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord))
            return 0;
        
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int steps = 1;
        
        while(!q.isEmpty()) {
            for(int k = q.size()-1; k >= 0; k--) {
                String word = q.poll();
                if(word.equals(endWord))
                    return steps;
                for(int i = 0; i < word.length(); i++) {
                    char[] newWord = word.toCharArray();
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        newWord[i] = ch;
                        String s = new String(newWord);
                        if(wordSet.contains(s) && s != word) {
                            q.offer(s);
                            wordSet.remove(s);
                        }
                    }
                }
            }
            steps++;
        }
        return 0;
    }
}