class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k];
        for(int[][] rows : dp){
            for(int[] row : rows){
                Arrays.fill(row, -1);
            }
        }
        return helper(prices, n, k, 0, 1, 0, dp); //0->index, 1->canbuy, 0->cnt
    }
    public int helper(int[] prices, int n, int k, int ind, int canbuy, int cnt, int[][][] dp){
        int profit = 0;
        if(ind==n) return 0;
        if(cnt==k) return 0;
        if(dp[ind][canbuy][cnt] != -1) return dp[ind][canbuy][cnt];

        if(canbuy==1){
            int buy = -prices[ind] + helper(prices, n, k, ind+1, 0, cnt, dp);
            int skip = helper(prices, n, k, ind+1, 1, cnt, dp);
            profit += Math.max(buy, skip);

        }
        else{
            int sell = prices[ind] + helper(prices, n, k, ind+1, 1, cnt+1, dp);
            int hold = helper(prices, n, k, ind+1, 0, cnt, dp);
            profit += Math.max(sell, hold);
        }
        return dp[ind][canbuy][cnt] = profit;
    }
}