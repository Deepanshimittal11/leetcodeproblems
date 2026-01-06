class Solution {
    public int minFallingPathSum(int[][] grid) {
        int minSum = Integer.MAX_VALUE;
        int n = grid.length;
        int[][] dp = new int[n+1][n+1];

        for(int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        for(int j=0;j<n;j++){
            minSum = Math.min(minSum, helper(grid, 0, j, dp));
        }
        return minSum;
    }
    public int helper(int[][] grid, int i, int j, int[][] dp){
        int n = grid.length;
        if(i==n-1) return grid[i][j];
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int mini = Integer.MAX_VALUE;
        for(int k=0;k<n;k++){
            if(k==j) continue;
            mini = Math.min(mini, helper(grid, i+1, k, dp));
        }

        dp[i][j] = grid[i][j] + mini;
        return dp[i][j];
    }
}