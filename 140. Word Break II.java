/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
*/

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new LinkedList<String>();
        Set<String> set = new HashSet<String>(wordDict);
        Map<String, List<String>> cache = new HashMap<>();
        res = helper(s, set, cache);
        return res;
    }
    
    public List<String> helper(String s, Set<String> set, Map<String, List<String>> cache){
        if (cache.containsKey(s)){
            return cache.get(s);
        }
        
        List<String> res = new LinkedList<>();
        if (s.length() == 0){
            //res.add("kekeke");
            //return res;
            return null;
        }
        for (int i = 1; i <= s.length(); i++){
            if (set.contains(s.substring(0,i))){
                List<String> temp = helper(s.substring(i,s.length()), set, cache);
                
                //if ( temp.size()!=0 && temp.get(0) == "kekeke"){ // the first word that added into the res
                if (temp == null){}
                    res.add(s.substring(0,i));
                } else{
                    for (String str: temp){
                        res.add(s.substring(0,i)+" "+str);
                    }
                } 
            }
            
        }
        cache.put(s, res);
        return res;
    }
}