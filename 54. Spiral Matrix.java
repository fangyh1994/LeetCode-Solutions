/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

class Solution {
    public void rotate(int[] nums, int k) {
        if (k > nums.length){
            k = k%nums.length;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            if ((i+k)<nums.length){
                result[i+k] = nums[i];
            } else if ((i+k) >= nums.length){
                result[i+k-nums.length] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++){
            nums[i] = result[i];
        }
        //return result;
    }
}

/*
O(1) extra space
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0){
            return result;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bot = matrix.length - 1;
        while ((left <= right) && (top <= bot)){
            //left->right
            for (int i = left; i <= right; i++){
                result.add(matrix[top][i]);
            }
            top++;
            if ((left > right) | (top > bot)){
              break;
            }
            for (int i = top; i <= bot; i++){
                result.add(matrix[i][right]);
            }
            right--;
            if ((left > right) | (top > bot)){
              break;
            }
            for (int i = right; i >= left; i--){
                result.add(matrix[bot][i]);
            }
            bot--;
            if ((left > right) | (top > bot)){
              break;
            }
            for (int i = bot; i >= top; i--){
                result.add(matrix[i][left]);
            }
            left++;
            if ((left > right) | (top > bot)){
              break;
            }
        }
        return result;
    }
}