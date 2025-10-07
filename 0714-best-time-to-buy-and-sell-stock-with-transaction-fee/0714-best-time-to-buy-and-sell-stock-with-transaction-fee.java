class Solution {
    //recursion : TLE
    // public int maxProfit(int[] prices, int fee) {
    //     return helper(prices, 0, 1, fee);
    // }
    // public int helper(int[] arr, int i, int canbuy, int fee){
    //     if(i == arr.length) return 0;
    //     if(canbuy == 1){
    //         int buy = -arr[i] -fee + helper(arr, i+1, 0, fee);
    //         int skip = helper(arr, i+1, 1, fee);
    //         return Math.max(buy, skip);
    //     }
    //     else{
    //         int sell = arr[i] + helper(arr, i+1, 1, fee);
    //         int hold = helper(arr, i+1, 0, fee);
    //         return Math.max(sell, hold);
    //     }
    // }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(prices, 0, 1, fee, dp);
    }
    public int helper(int[] arr, int i, int canbuy, int fee, int[][] dp){
        if(i == arr.length) return 0;
        if(dp[i][canbuy] != -1) return dp[i][canbuy];
        if(canbuy == 1){
            int buy = -arr[i] -fee + helper(arr, i+1, 0, fee, dp);
            int skip = helper(arr, i+1, 1, fee, dp);
            dp[i][canbuy] = Math.max(buy, skip);
        }
        else{
            int sell = arr[i] + helper(arr, i+1, 1, fee, dp);
            int hold = helper(arr, i+1, 0, fee, dp);
            dp[i][canbuy] = Math.max(sell, hold);
        }
        return dp[i][canbuy];
    }
}