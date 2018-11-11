/*
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.

 

Example 1:

Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 

Note:

0 <= logs.length <= 100
3 <= logs[i].length <= 100
logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> StringComparator = new Comparator<String>() {
            @Override
            public int compare (String s1, String s2) {
                if (isLetterLog(s1) && !isLetterLog(s2)) {
                    return -1;
                } else if (isLetterLog(s1) && isLetterLog(s2)){
                    String[] array1 = s1.split(" ");
                    String[] array2 = s2.split(" ");
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0; i < s1.length(); i++) {
                        if (s1.charAt(i) == ' ') {
                            index1 = i;
                            break;
                        }
                    }
                    for (int i = 0; i < s2.length(); i++) {
                        if (s2.charAt(i) == ' ') {
                            index2 = i;
                            break;
                        }
                    }
                    return (s1.substring(index1+1).compareTo(s2.substring(index2+1)));
                    //for (int i = 1; i < Math.min(array1.length, array2.length); i++) {
                        //return array1[1].compareTo(array2[1]);  
                    //}
                } else if (!isLetterLog(s1) && isLetterLog(s2) ){
                    return 1;    
                }
                return 0;
            }
        };
        Arrays.sort(logs, StringComparator);
        return logs;
    }
    
    public boolean isLetterLog(String s) {
        String[] array = s.split(" ");
        if (array[1].charAt(0) - '0' >= 0 && array[1].charAt(0) - '0' <= 9 ) {
            return false;
        } else {
            return true;
        }
    }
    
}