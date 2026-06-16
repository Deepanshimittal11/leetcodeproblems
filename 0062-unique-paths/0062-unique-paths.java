class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        // down or right only.
        dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(0, 0, m, n, 0, dp);
    }
    public int helper(int i, int j, int m, int n, int ans, int[][] dp){
        if(i>=m || j>=n) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        
        dp[i][j] = helper(i+1, j, m, n, ans, dp) + helper(i, j+1, m, n, ans, dp);
        return dp[i][j];
    }
}