/*
Given an array of 4 digits, return the largest 24 hour time that can be made.

The smallest 24 hour time is 00:00, and the largest is 23:59.  Starting from 00:00, a time is larger if more time has elapsed since midnight.

Return the answer as a string of length 5.  If no valid time can be made, return an empty string.

 

Example 1:

Input: [1,2,3,4]
Output: "23:41"
Example 2:

Input: [5,5,5,5]
Output: ""
 

Note:

A.length == 4
0 <= A[i] <= 9
*/
class Solution {
    public String largestTimeFromDigits(int[] A) {
        String time = "";
        String str = "";
        for (int a : A) {
            str += Integer.toString(a);
        }
        List <String> list = new ArrayList<>();
        
        permutation("", str, list);
        
        for (String s: list) {
            s = s.substring(0,2) + ":"+s.substring(2);
            if (s.charAt(3) < '6') {
                if(s.charAt(0) <= '2' && s.compareTo("24:00") < 0) {
                    time = time.compareTo(s) > 0 ? time : s;
                }
            }
        }
        return time;
    }
    
    public static void permutation(String prefix, String str, List<String> list) {
        int n = str.length();
        if(n == 0) {list.add(prefix);}
        else {
            for (int i = 0; i < n; i++) {
                permutation(prefix+str.charAt(i), str.substring(0,i) + str.substring(i+1), list);
            }
        }
    }
}