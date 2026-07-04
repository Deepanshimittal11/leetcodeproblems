class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }

        int ans = helper(coins, amount, n-1, dp);
        if(ans >= (int)1e9) return -1;
        return ans;
    }
    public int helper(int[] coins, int amount, int ind, int[][] dp){
        if(ind == 0){
            if(amount % coins[0] == 0) return amount/coins[0];
            return Integer.MAX_VALUE;
        }
        if(dp[ind][amount] != -1) return dp[ind][amount];

        int notTake = helper(coins, amount, ind-1, dp);
        int take = (int)1e9;
        if(coins[ind] <= amount){
            take = 1 + helper(coins, amount-coins[ind], ind, dp);
        }

        return dp[ind][amount] = Math.min(take, notTake);
    }
}