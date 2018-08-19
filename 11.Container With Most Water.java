/*
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
*/

class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int maxArea = 0;
        while (end > start){
            maxArea = Math.max(maxArea, area(start,end,height[start],height[end]) );
            if (height[start] > height[end]){
                end--;
            }else{
                start++;
            }
        }
        return maxArea;
    }
    public int area(int a, int b, int c, int d){
        if (c>=d){
            return d*(b-a);
        }else{
            return c*(b-a);
        }
        
    }
}