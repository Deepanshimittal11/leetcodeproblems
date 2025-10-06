class Solution {
    //recursion:
    // public int maxProfit(int[] prices) {
    //     return helper(prices, 0, 1, 2);
    // }
    // public int helper(int[] arr, int i, int canbuy, int k){
    //     if(i == arr.length) return 0;
    //     if(k == 0) return 0;
    //     if(canbuy == 1){
    //         int buy = -arr[i] + helper(arr, i+1, 0, k);
    //         int skip = helper(arr, i+1, 1, k);
    //         return Math.max(buy, skip);
    //     }else{
    //         int sell = arr[i] + helper(arr, i+1, 1, k-1);
    //         int hold = helper(arr, i+1, 0, k);
    //         return Math.max(sell, hold);
    //     }
    // }

    //dp:
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int[][] row : dp){
            for(int[] row1 : row){
                Arrays.fill(row1,-1);
            }
        }
        return helper(prices, 0, 1, 2, dp);
    }
    public int helper(int[] arr, int i, int canbuy, int k, int[][][] dp){
        if(i == arr.length) return 0;
        if(k == 0) return 0;
        if(dp[i][canbuy][k] != -1) return dp[i][canbuy][k];
        if(canbuy == 1){
            int buy = -arr[i] + helper(arr, i+1, 0, k, dp);
            int skip = helper(arr, i+1, 1, k,dp);
            dp[i][canbuy][k] = Math.max(buy, skip);
        }else{
            int sell = arr[i] + helper(arr, i+1, 1, k-1, dp);
            int hold = helper(arr, i+1, 0, k, dp);
            dp[i][canbuy][k] = Math.max(sell, hold);
        }
        return dp[i][canbuy][k];
    }
}