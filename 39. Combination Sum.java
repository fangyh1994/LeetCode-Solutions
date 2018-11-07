/*
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

 */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        helper(res, temp, candidates, 0, target);
        return res;
    }
    
    public void helper (List<List<Integer>> res, List<Integer> temp, int[] candidates, int index, int target) {
        if (target == 0){
            res.add(new ArrayList<>(temp));
        } else if (target > 0){
            for (int i = index; i < candidates.length; i++) {
                if (candidates[i] <= target) {
                    temp.add(candidates[i]);
                    helper(res, temp, candidates, i, target-candidates[i]);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}