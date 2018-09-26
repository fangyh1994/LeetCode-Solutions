/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
Example:

Input: [2,1,5,6,2,3]
Output: 10
*/
class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int lo = i;
            int hi = i;
            while (hi < heights.length && heights[hi] >= heights[i]){
                hi++;
            }
            while (lo >=0 && heights[lo] >= heights[i]){
                lo--;
            }
            result = Math.max(result, heights[i]*(hi-lo-1));
        }
        return result;
    }
}