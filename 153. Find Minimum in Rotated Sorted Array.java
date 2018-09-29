/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
*/

class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        if (nums.length == 1){
            return nums[0];
        }
        if (nums[lo] < nums[hi]){
            return nums[lo];
        }
        while (lo < hi){
            int mid = (lo + hi)/2;
            // if the mid element is greater than its next element then mid+1 element is the smallest
            // This point would be the point of change. From higher to lower value.
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // if the mid element is lesser than its previous element then mid element is the smallest
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] < nums[0]){
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
        
    }
}