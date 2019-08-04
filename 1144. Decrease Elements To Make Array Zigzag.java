/*
Given an array nums of integers, a move consists of choosing any element and decreasing it by 1.

An array A is a zigzag array if either:

Every even-indexed element is greater than adjacent elements, ie. A[0] > A[1] < A[2] > A[3] < A[4] > ...
OR, every odd-indexed element is greater than adjacent elements, ie. A[0] < A[1] > A[2] < A[3] > A[4] < ...
Return the minimum number of moves to transform the given array nums into a zigzag array.

 

Example 1:

Input: nums = [1,2,3]
Output: 2
Explanation: We can decrease 2 to 0 or 3 to 1.
Example 2:

Input: nums = [9,6,1,6,2]
Output: 4
*/
class Solution {
    public int movesToMakeZigzag(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        int count1 = 0;
        int count2 = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            if(i % 2 == 0) {
                if(i == 0) {
                    count1 += nums[i] >= nums[i + 1] ? nums[i] - nums[i + 1] + 1 : 0;
                } else if(i == nums.length - 1) {
                    count1 += nums[i] >= nums[i - 1] ? nums[i] - nums[i - 1] + 1 : 0;
                } else {
                    count1 += nums[i] >= Math.min(nums[i - 1], nums[i + 1]) ? nums[i] - Math.min(nums[i - 1], nums[i + 1]) + 1 : 0;
                }
            } else {
                if(i == nums.length - 1) {
                    count2 += nums[i] >= nums[i - 1] ? nums[i] - nums[i - 1] + 1 : 0;
                } else {
                    count2 += nums[i] >= Math.min(nums[i - 1], nums[i + 1]) ? nums[i] - Math.min(nums[i - 1], nums[i + 1]) + 1 : 0;
                }
            }
        }
        return Math.min(count1, count2);
    }
}