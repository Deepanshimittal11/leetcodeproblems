class Solution {
    public int coinChange(int[] coins, int amount) {
        int inf = (int)1e9;

        int[] dp = new int[amount+1];

        Arrays.fill(dp, inf);
        dp[0] = 0;
        
        for(int coin : coins){
            for(int i=coin;i<=amount;i++){
                dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return dp[amount] >= inf ? -1 : dp[amount];
    }
}