/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/

class Solution {
    public int trap(int[] height) {
        if (height.length == 0 || height.length == 1){
            return 0;
        }
        int result = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        max_left[0] = height[0];
        for (int i = 1; i < height.length - 1; i++)
        {
            max_left[i] = Math.max(height[i], max_left[i-1]);
        }
        max_right[height.length-1] = height[height.length-1];
        for (int i = height.length-2; i >= 0; i--){
            max_right[i] = Math.max(height[i], max_right[i+1]);
        }
        for (int i = 0; i < height.length-1; i++){
            result += Math.min(max_left[i],max_right[i])-height[i];
        }
        return result;
    }
}