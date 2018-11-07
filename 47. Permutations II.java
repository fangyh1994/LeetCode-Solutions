/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        helper(res, temp, nums, new int[nums.length]);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, int[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i] != 0){
                    continue;
                }
                if (i < nums.length - 1 && nums[i+1] == nums[i] && visited[i+1] == 0){
                    continue;
                }
                if (visited[i] == 0) {
                    temp.add(nums[i]);
                    visited[i] = 1;
                    helper(res, temp, nums, visited);
                    visited[i] = 0;
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}