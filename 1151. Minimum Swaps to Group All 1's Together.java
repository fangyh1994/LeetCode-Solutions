/*
Given a binary array data, return the minimum number of swaps required to group all 1’s present in the array together in any place in the array.

 

Example 1:

Input: [1,0,1,0,1]
Output: 1
Explanation: 
There are 3 ways to group all 1's together:
[1,1,1,0,0] using 1 swap.
[0,1,1,1,0] using 2 swaps.
[0,0,1,1,1] using 1 swap.
The minimum is 1.
Example 2:

Input: [0,0,0,1,0]
Output: 0
Explanation: 
Since there is only one 1 in the array, no swaps needed.
Example 3:

Input: [1,0,1,0,1,0,0,1,1,0,1]
Output: 3
Explanation: 
One possible solution that uses 3 swaps is [0,0,0,0,0,1,1,1,1,1,1].
*/
class Solution {
    public int minSwaps(int[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }
        int ans = data.length - 1;
        int count1 = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 1) {
                count1++;
            }
        }
        int left = 0;
        int right = count1 - 1;
        int temp_ans = 0;
        for (int i = 0; i <= right; i++) {
            if (data[i] != 1) {
                temp_ans++;
            }
        }
        ans = Math.min(ans, temp_ans);
        for (int i = 1; i <= data.length - count1; i++) {
            if (data[left + i - 1] == 0) {
                temp_ans--;
            } else {
            }
            if (data[right + i] == 0) {
                temp_ans++;
            } else {
            }
            ans = Math.min(ans, temp_ans);
        }
        return ans;
    }
}