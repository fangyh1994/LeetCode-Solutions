/*
Given a sorted integer array without duplicates, return the summary of its ranges.

Example 1:

Input:  [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
Example 2:

Input:  [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
*/

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List <String> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            
            while ((i != (nums.length-1)) && (nums[i+1] == nums[i]+1)) {
                i++;
            }
            int end = nums[i];
            if (start == end){
                res.add(Integer.toString(start));
            } else {
                String temp = "";
                temp += Integer.toString(start);
                temp += "->";
                temp += Integer.toString(end);
                res.add(temp);
            }
            
        }
        return res;
    }
}