class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }
        return helper(prices, n, 0, 1, dp);
    }
    public int helper(int[] prices, int n, int ind, int canbuy, int[][] dp){
        int profit = 0;
        if(ind==n) return 0;
        if(dp[ind][canbuy] != -1) return dp[ind][canbuy];

        if(canbuy==1){
            int buy = -prices[ind] + helper(prices, n, ind+1, 0,dp);
            int skip = helper(prices, n, ind+1, 1, dp);
            profit += Math.max(buy, skip);
        }
        else{
            int sell = prices[ind] + helper(prices, n, ind+1, 1, dp);
            int hold = helper(prices, n, ind+1, 0, dp);
            profit += Math.max(sell, hold);
        }
        return dp[ind][canbuy] = profit;
    }
}