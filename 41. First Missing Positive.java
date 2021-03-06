/*
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length){
            if (nums[i] == i+1 || nums[i] <= 0 || nums[i] > nums.length){
                i++;
            } else if (nums[nums[i] - 1] != nums[i]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i]; 
                nums[i] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1){
                return j+1;
            }
        }
        return nums.length + 1;
    }
}