class Solution {
    //brute force approch:
    // public int maxProfit(int[] prices) {
    //    int price = Integer.MAX_VALUE;
    //    int maxProfit = 0;
    //    int n = prices.length-1;
    //    for(int i=0;i<=n;i++){
    //         if(prices[i]<price){
    //             price = prices[i];
    //         }
    //         else{
    //             int profit = prices[i] - price;
    //             maxProfit = Math.max(maxProfit, profit);
    //         }
    //    }
    //    return maxProfit;
    // }


    //recursion:
    // it will give TLE 
    // public int maxProfit(int[] prices) {
    // return helper(prices, 0, 1, 0); // 0 means startday, 1 means canbuy=true
    // }
    // public int helper(int[] arr, int i, int canBuy, int done){
    //     if(i==arr.length) return 0;
    //     if(done == 1) return 0; //transaction done.
    //     if(canBuy == 1){
    //         //2 choices: buy or skip
    //         int buy = -arr[i] + helper(arr, i+1, 0, 0);
    //         int skip = helper(arr, i+1, 1, 0);
    //         return Math.max(buy, skip);
    //     }
    //     else{
    //         //2 choices: sell or hold
    //         int sell = arr[i] + helper(arr, i+1, 1, 1);
    //         int hold = helper(arr, i+1, 0, 0);
    //         return Math.max(sell, hold);
    //     }
    // }


    //DP with memoization (top down)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(prices, 0, 1,0, dp);
    }
    public int helper(int[] arr,int i, int canbuy,int done, int[][] dp){
        if(i == arr.length) return 0;
        if(done == 1) return 0;
        if(dp[i][canbuy] != -1) return dp[i][canbuy];
        if(canbuy == 1){
            int buy = -arr[i] + helper(arr, i+1, 0,0, dp);
            int skip = helper(arr, i+1, 1,0, dp);
            dp[i][canbuy] = Math.max(buy, skip);
        }else{
            int sell = arr[i] + helper(arr, i+1, 1,1, dp);
            int hold = helper(arr, i+1, 0,0, dp);
            dp[i][canbuy] = Math.max(sell, hold);
        }
        return dp[i][canbuy];
    }
}