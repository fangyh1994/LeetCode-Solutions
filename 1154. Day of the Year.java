/*
Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.

 

Example 1:

Input: date = "2019-01-09"
Output: 9
Explanation: Given date is the 9th day of the year in 2019.
Example 2:

Input: date = "2019-02-10"
Output: 41
Example 3:

Input: date = "2003-03-01"
Output: 60
Example 4:

Input: date = "2004-03-01"
Output: 61
*/
class Solution {
    public int dayOfYear(String date) {
        if (date == null || date.length() == 0) {
            return 0;
        }
        int[] month = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        int ans = 0;
        int currYear = Integer.parseInt(date.substring(0,4));
        int currMonth = Integer.parseInt(date.substring(5,7));
        int currDay = Integer.parseInt(date.substring(8));
        for (int i = 0; i < currMonth - 1; i++) {
            ans += month[i];
        }
        ans+= currDay;
        if (((currYear % 4 == 0 && currYear % 100 != 0 ) || currYear % 400 == 0) && currMonth >= 3) {
            ans++;
        }
        return ans;
    }
}