/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> each = new ArrayList<Integer>();
        helper(result, each, 0, nums);
        return result;
    }
    public void helper(List<List<Integer>> result, List<Integer> each, int currIndex, int[] nums){
        result.add(each);
        for (int i = currIndex; i < nums.length; i++){
            if (i != currIndex && nums[i] == nums[i-1]){
                continue;
            }
            each.add(nums[i]);
            helper (result, new ArrayList<>(each), i+1, nums);
            each.remove(each.size()-1);
        }
    }
}