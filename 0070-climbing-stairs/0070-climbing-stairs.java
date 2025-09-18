class Solution {
    public int climbStairs(int n) {
        // this solution is done through recursion b/c the contraints are low.
        // int prev1 = 1;
        // int prev2 = 1;
        // int curr = 0;
        // for(int i=2;i<=n;i++){
        //     curr = prev1+prev2;
        //     prev1 = prev2;
        //     prev2 = curr;
        // }
        // return prev2;

        //we can do this with DP:
        if(n==1) return 1;
        if(n==2) return 2;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}