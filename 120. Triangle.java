/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        List<List<Integer>> dp = new ArrayList<List<Integer>>();
        List<Integer> first = new ArrayList<Integer>();
        first.add(0);
        dp.add(first);
        for (int i = 1; i <= triangle.size(); i++){
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(dp.get(i-1).get(0) + triangle.get(i-1).get(0));
            //temp.add(1);
            for (int j = 1; j < triangle.get(i-1).size(); j++) {
                int left = dp.get(i-1).get(j-1) + triangle.get(i-1).get(j-1);
                int right = dp.get(i-1).get(j) + triangle.get(i-1).get(j);
                int shortest = Math.min(left, right);
                temp.add(shortest);
            }
            temp.add(dp.get(i-1).get(i-1)+triangle.get(i-1).get(i-1));
            //temp.add(1);
            dp.add(temp);
        }
        int result = dp.get(dp.size()-1).get(0);
        for (int i = 0; i < dp.get(dp.size() - 1).size(); i++){
            result = Math.min(result, dp.get(dp.size() - 1).get(i));
        }
        
        return result;
    }
}