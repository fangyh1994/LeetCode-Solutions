/*
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        Map <String, List> res = new HashMap<String, List>();
        for (String s: strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String sorted = new String(temp);
            if (res.containsKey(sorted)) {
                res.get(sorted).add(s);
            } else {
                List <String> list = new ArrayList<String>();
                list.add(s);
                res.put(sorted, list);
            }
        }
        return new ArrayList(res.values());
    }
}