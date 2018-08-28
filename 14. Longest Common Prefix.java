/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        Boolean isPre = true;
        int maxPrefix = 0;
        for (int j = 0; j < strs[0].length(); j++){
            int i = 0;
            isPre = true;
            while (i < strs.length){
                if ( isPrefix(strs[0].substring(0,j+1), strs[i]) == false) {
                    isPre = false;
                    break;
                }
                i++;
            }
            if (isPre == true){
                result = strs[0].substring(0,j+1);
            }
            
        }
        return result;
    }
    
    public Boolean isPrefix(String a, String b){
        if (a.length() > b.length()){
            return false;
        }
        int i = 0;
        while (i < a.length() ){
            if (a.charAt(i) != b.charAt(i)){
                return false;
            }
            i++;
        }
        return true;
    }
}
/* approach 2
public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    for (int i = 0; i < strs[0].length() ; i++){
        char c = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j ++) {
            if (i == strs[j].length() || strs[j].charAt(i) != c)
                return strs[0].substring(0, i);             
        }
    }
    return strs[0];
}
*/
