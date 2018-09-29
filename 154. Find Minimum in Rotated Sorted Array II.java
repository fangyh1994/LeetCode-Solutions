/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1
Example 2:

Input: [2,2,2,0,1]
Output: 0
Note:

This is a follow up problem to Find Minimum in Rotated Sorted Array.
Would allow duplicates affect the run-time complexity? How and why?
*/

class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        if (nums.length == 1){
            return nums[0];
        }
        while (lo < hi){
            if (nums[lo] < nums[hi]){
                return nums[lo];
            }
            int mid = (lo + hi)/2;
            if (nums[mid] > nums[mid+1]){
                return nums[mid + 1];
            }
            if (mid > 0 && nums[mid-1] > nums[mid]){
                return nums[mid];
            }

            if (nums[mid] < nums[lo]){
                hi = mid;
            } else if (nums[mid] > nums[lo]){
                lo = mid + 1;
            } else{
                lo++;
            }
        }
        return nums[lo];
    }
}