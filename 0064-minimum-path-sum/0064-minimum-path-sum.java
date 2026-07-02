class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }

        return helper(grid, m-1, n-1, dp);
    }
    public int helper(int[][] grid, int i, int j, int[][] dp){
        int minsum = Integer.MAX_VALUE;

        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return Integer.MAX_VALUE;
        if(dp[i][j] != -1) return dp[i][j];

        int left = helper(grid, i, j-1, dp);
        int up = helper(grid, i-1, j, dp);

        return dp[i][j] = Math.min(left, up) + grid[i][j];
    }
}