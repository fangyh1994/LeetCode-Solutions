/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 ¡ú 1,3,2
3,2,1 ¡ú 1,2,3
1,1,5 ¡ú 1,5,1
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1){
            return;
        }
        int pivot = nums.length-2;
        int temp = 100000;
        int tempindex = nums.length-1;
        int index = nums.length - 1;
        while (nums[index-1] >= nums[index]){
            index--;
            if (index == 0) {
                multiswap (nums, 0, nums.length-1);
                return;
                //pivot = -1;
                //break;
            }
            pivot = index - 1;
        } 
        if (pivot != -1){
            for (int i = nums.length - 1; i > pivot; i--){
                if ((nums[i] > nums[pivot]) && nums[i] < temp){
                    temp = nums[i];
                    tempindex = i;
                }
            }
            //swap (pivot-1, i);
            nums[tempindex] = nums[pivot];
            nums[pivot] = temp;
        }
        multiswap (nums, pivot+1, nums.length-1);
    }
    public void multiswap (int[] nums, int left, int right){
        for (int i = 0; i <= (right-left)/2; i++){
            int temp = nums[left+i];
            nums[left+i] = nums[right-i];
            nums[right-i] = temp;
        }
    }
}