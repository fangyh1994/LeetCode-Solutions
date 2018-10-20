/*
Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

Example:

Input: nums = [3,5,2,1,6,4]
Output: One possible answer is [3,5,1,6,2,4]
 */
class Solution {
    public void wiggleSort(int[] nums) {
        if (nums.length == 0){
            return;
        }
        boolean sign = true;
        for (int i = 0; i < nums.length-1; i ++){
            if (sign){
                if (nums[i] <= nums[i+1]){
                } else {
                    swap (nums, i, i+1);
                }
            } else {
                if (nums[i] >= nums[i+1]){
                } else {
                    swap (nums, i, i+1);
                }
            }
            sign = !sign;
        }
    }
    public void swap(int[] nums ,int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
        return;
    }
}