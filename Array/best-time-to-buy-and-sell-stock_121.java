// Question Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currMin = prices[0];
        for(int i=1; i<prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i]-currMin);
            currMin = Math.min(currMin, prices[i]);
        }
        return maxProfit;    
    }
}