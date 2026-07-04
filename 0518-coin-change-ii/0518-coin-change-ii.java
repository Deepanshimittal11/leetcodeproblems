class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[amount+1][n+1];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }
        return helper(amount, coins, n-1, dp);
    }
    public int helper(int amt, int[] coins, int ind, int[][] dp){
        if(ind==0){
            if(amt%coins[0] == 0) return 1;
            return 0;
        }
        if(dp[amt][ind] != -1) return dp[amt][ind];

        int notTake = helper(amt, coins, ind-1, dp);
        int take = 0;
        if(coins[ind] <= amt){
            take = helper(amt-coins[ind], coins, ind, dp);
        }
        return dp[amt][ind] = take+notTake;
    }
}