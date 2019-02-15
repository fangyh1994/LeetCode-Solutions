/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        helper(ans, temp, 0, n, k);
        return ans;
    }
    
    private void helper (List<List<Integer>> ans, List<Integer> temp, int index, int n, int k) {
        if (temp.size() == k) {     
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = index+1; i <= n; i++) {
            if (temp.indexOf(i) == -1) {
                temp.add(i);
                helper(ans, temp, i, n, k);
                temp.remove(temp.size()-1);
            }
        }
    }
}