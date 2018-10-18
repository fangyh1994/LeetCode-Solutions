/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int max[] = new int[nums.length];
        max[0] = Math.max(res,nums[0]);
        res = Math.max(res,max[0]);
        for (int i = 1; i < nums.length; i++){
            max[i] = Math.max(nums[i], nums[i]+max[i-1]);
            res = Math.max(res, max[i]);
        }
        return res;
    }
}