/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/

class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        if (prices.length == 1 || prices.length == 0){
            return 0;
        }
        //int[] profitarray = new int[prices.length];
        for (int i = 1; i < prices.length - 1; i++){
            //profitarray[i] = maxProfit(prices,0,i) + maxProfit(prices, i+1, prices.length - 1);
            result = Math.max(result, maxProfit(prices,0,i) + maxProfit(prices, i+1, prices.length - 1));
        }
        //return result;
        return Math.max(result, maxProfit(prices,0,prices.length-1));
    }
    
    private int maxProfit(int[] prices, int start, int end){
        int result = 0;
        if (prices.length == 0){
            return 0;
        }
        if (start == end){
            return 0;
        }
        int min = prices[start];
        int max = prices[start];
        for (int i = start; i <= end; i++){
            max = Math.max(max, prices[i]);
            result = Math.max(result, max - min);
            if (prices[i] < min){
                min = prices[i];
                max = prices[i];
            }
        }
        return result;
    }
}