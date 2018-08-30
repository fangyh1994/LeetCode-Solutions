/*
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int res = min;
        Arrays.sort(nums);
        for (int i =0; i < nums.length -2; i++){
            int j = i+1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if (Math.abs(target - sum) < min){
                    min = Math.abs(target - sum);
                    res = sum;  
                }
                if (sum > target){
                    k--;
                }
                if (sum < target){
                    j++;
                }   
                if (sum == target){
                    return sum;
                }
            }
        }
        return res;
    }
}