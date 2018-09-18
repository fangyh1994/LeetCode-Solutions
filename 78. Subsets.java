/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> each = new ArrayList<Integer>();
        helper(result, each, 0, nums);
        return result;
    }
    public void helper(List<List<Integer>> result, List<Integer> each, int currIndex, int[] nums){
        result.add(each);
        for (int i = currIndex; i < nums.length; i++){
            each.add(nums[i]);
            helper (result, new ArrayList<>(each), i+1, nums);
            each.remove(each.size()-1);
        }
    }
}