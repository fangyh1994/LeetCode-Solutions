/*
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3;i++){
            /*
            if (i > 0 && nums[i] == nums[i+1]){
                continue;
            }
            */
            int[] tempnums = new int[nums.length-i-1];
            for (int m = 0; m < tempnums.length;m++){
                tempnums[m] = nums[i+m+1];
            }
            
            List<List<Integer>> tempresult = threeSum(tempnums, target-nums[i]);
            for (int j = 0; j < tempresult.size(); j++){
                tempresult.get(j).add(0, nums[i]);
                if (!result.contains(tempresult.get(j))){
                    result.add( tempresult.get(j));
                } 
            }
        }
        return result;
    }
    
    private List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length -2;i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int pointer_j = i+1;
            int pointer_k = nums.length - 1;
            while(pointer_j < pointer_k){
                if(nums[i] + nums[pointer_j] + nums[pointer_k] == target){
                    List<Integer> triplets = new ArrayList<Integer>();
                    triplets.add(nums[i]);
                    triplets.add(nums[pointer_j]);
                    triplets.add(nums[pointer_k]);
                    result.add(triplets);
                    while (pointer_j<pointer_k && (nums[pointer_j] == nums[pointer_j+1])) {pointer_j++;}
                    while (pointer_j<pointer_k && (nums[pointer_k] == nums[pointer_k-1])) {pointer_k--;}
                    pointer_j++;
                }
                if (pointer_j<pointer_k && nums[i] + nums[pointer_j] + nums[pointer_k] > target){
                    pointer_k--;
                } 
                else if (pointer_j<pointer_k && nums[i] + nums[pointer_j] + nums[pointer_k] < target){
                    pointer_j++;
                }
            }
        }
        return result;
    }
}