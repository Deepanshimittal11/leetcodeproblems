class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }

        if(obstacleGrid[m-1][n-1] == 1) return 0;
        return helper(obstacleGrid, m-1, n-1, dp);
    }
    public int helper(int[][] grid, int i, int j, int[][] dp){
        if(i<0 || j<0) return 0; 
        if(i==0 && j==0) return 1;
        if(dp[i][j] != -1) return dp[i][j];

        int left = 0;
        int up = 0;
        if(i>0){
            up = (grid[i-1][j] != 1) ?  helper(grid, i-1, j, dp) : 0;
        }
        if(j>0){
            left = (grid[i][j-1] != 1) ? helper(grid, i, j-1, dp) : 0;
 
        }
        return dp[i][j] = left + up;
    }
}