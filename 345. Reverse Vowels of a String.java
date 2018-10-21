/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".
 */
class Solution {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int lo = 0;
        int hi = str.length - 1;
        while (lo < hi) {
            while (lo < hi && !set.contains(str[lo])){
                lo++;
            }
            while (lo < hi && !set.contains(str[hi])){
                hi--;
            }
            char temp = str[lo];
            str[lo] = str[hi];
            str[hi] = temp;
            lo++;
            hi--;
        }
        return new String(str);
    }
}