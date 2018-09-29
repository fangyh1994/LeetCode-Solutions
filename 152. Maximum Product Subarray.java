/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempmax = max;
            int tempmin = min;
            max = Math.max(Math.max(tempmax*nums[i], nums[i]), tempmin*nums[i]);
            min = Math.min(Math.min(tempmin*nums[i], nums[i]), tempmax*nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }
}