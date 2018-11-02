/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[] {-1, -1};
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (mid == 0) {
                if (nums[mid] == target) {
                    res[0] = 0;
                    break;
                } else if (nums[mid] > target){
                    break;
                } else if (nums[mid] < target) {
                    lo = mid + 1;
                }
            } else {
                if (nums[mid - 1] != target && nums[mid] == target) {
                    res[0] = mid;
                    break;
                } else if (nums[mid] < target) {
                    lo = mid + 1;
                } else if (nums[mid] > target){
                    hi = mid - 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        lo = 0;
        hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (mid == nums.length-1) {
                if (nums[mid] == target) {
                    res[1] = nums.length-1;
                    break;
                } else if (nums[mid] < target){
                    break;
                } else if (nums[mid] > target) {
                    hi = mid - 1;
                }
            } else {
                if (nums[mid + 1] != target && nums[mid] == target) {
                    res[1] = mid;
                    break;
                } else if (nums[mid] < target) {
                    lo = mid + 1;
                } else if (nums[mid] > target){
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return res;
    }
}