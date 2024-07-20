// Question Link : 
class Solution { //Memoization code
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(0, 1, prices, dp);
    }
    public int solve(int ind, int canBuy, int[] prices, int[][] dp){
        if(ind == prices.length){
            return 0;
        }
        if(dp[ind][canBuy] != -1){
            return dp[ind][canBuy];
        }
        if(canBuy == 1){
            dp[ind][canBuy] = Math.max(-prices[ind] + solve(ind+1, 0, prices, dp), solve(ind+1, 1, prices, dp));
        }
        else{
            dp[ind][canBuy] = Math.max(prices[ind] + solve(ind+1, 1, prices, dp), solve(ind+1, 0, prices, dp));
        }
        return dp[ind][canBuy];
    }
}