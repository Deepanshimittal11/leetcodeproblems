class Solution {
    //recursion:
    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     int n = obstacleGrid.length;
    //     int m = obstacleGrid[0].length;
    //     if(obstacleGrid[0][0] == 1) return 0;
    //     if(obstacleGrid[n-1][m-1]==1) return 0;
    //     return helper(0,0,n,m, obstacleGrid);
    // }
    // public int helper(int i, int j, int n, int m, int[][] obstacleGrid){
    //     //if he is on the right track then, cnt 1;
    //     if(i==n-1 && j==m-1) return 1;
    //     //if he is not on the right track then do not cnt and return 0;
    //     if(i>=n || j>=m) return 0;

    //     int cnt = 0;
    //     //same for this , if obstacle is present return 0.
    //     if(obstacleGrid[i][j] == 1){
    //         return 0;
    //     }

    //     int right = helper(i, j+1, n, m, obstacleGrid);
    //     int bottom = helper(i+1, j, n, m, obstacleGrid);

    //     return right+bottom;
    // }


    //dp:
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        if(obstacleGrid[n-1][m-1]==1) return 0;
        int[][] dp = new int[n][m];
        for(int[] rows : dp) Arrays.fill(rows, -1);
        return helper(0,0,n,m, obstacleGrid, dp);
    }
    public int helper(int i, int j, int n, int m, int[][] obstacleGrid, int[][] dp){
        if(i==n-1 && j==m-1) return 1;
        if(i>=n || j>=m || obstacleGrid[i][j] == 1) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        int right = helper(i, j+1, n, m, obstacleGrid, dp);
        int bottom = helper(i+1, j, n, m, obstacleGrid, dp);
        return dp[i][j] = right + bottom;
    }
}