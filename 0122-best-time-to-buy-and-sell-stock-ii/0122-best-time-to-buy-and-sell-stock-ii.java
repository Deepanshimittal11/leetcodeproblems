class Solution {
    //recursion:
    //give TLE
    // public int maxProfit(int[] prices) {
    //     return helper(prices, 0, 1);
    // }
    // //canbuy = 1 hum abhi buy kar sakte hain
    // //canBuy = 0  hum abhi sell kar sakte hain 
    // public int helper(int[] arr, int i, int canbuy){
    //     if(i == arr.length) return 0;
    //     if(canbuy == 1){
    //         int buy = -arr[i] + helper(arr, i+1, 0);
    //         int skip = helper(arr, i+1, 1);
    //         return Math.max(buy, skip);
    //     }else{
    //         int sell = arr[i] + helper(arr, i+1, 1);
    //         int hold = helper(arr, i+1, 0);
    //         return Math.max(sell, hold);
    //     }
    // }

    //dp
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(prices, 0, 1, dp);
    }
    public int helper(int[] arr, int i, int canbuy, int[][] dp){
        if(i == arr.length) return 0;
        if(dp[i][canbuy] != -1) return dp[i][canbuy]; 
        if(canbuy == 1){
            int buy = -arr[i] + helper(arr, i+1, 0, dp);
            int skip = helper(arr, i+1, 1, dp);
            dp[i][canbuy] = Math.max(buy, skip);
        }else{
            int sell = arr[i] + helper(arr, i+1, 1, dp);
            int hold = helper(arr, i+1, 0, dp);
            dp[i][canbuy] = Math.max(sell, hold);
        }
        return dp[i][canbuy];
    }
}