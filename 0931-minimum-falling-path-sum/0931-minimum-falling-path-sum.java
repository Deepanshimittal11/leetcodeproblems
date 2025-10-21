class Solution {
    //recursion:
    // public int minFallingPathSum(int[][] matrix) {
    //     int n = matrix.length;
    //     int minsum = Integer.MAX_VALUE;
    //     for(int j=0;j<n;j++){
    //         minsum = Math.min(minsum, helper(matrix, 0, j));
    //     }
    //     return minsum;
    // }
    // public int helper(int[][] matrix, int i, int j){
    //     int n = matrix.length;

    //     if(j<0 || j>=n) return Integer.MAX_VALUE;
    //     if(i==n-1) return matrix[i][j];

    //     int down = helper(matrix, i+1, j);
    //     int downleft = helper(matrix, i+1, j-1);
    //     int downright = helper(matrix, i+1, j+1);

    //     int sum = matrix[i][j] + Math.min(down, Math.min(downleft, downright));
    //     return sum;
    // }

    //dp:
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int minsum = Integer.MAX_VALUE;
        int[][] dp = new int[n][n];

        for(int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);

        for(int j=0;j<n;j++){
            minsum = Math.min(minsum, helper(matrix, 0, j, dp));
        }
        return minsum;
    }
    public int helper(int[][] matrix, int i, int j, int[][] dp){
        int n = matrix.length;

        if(j<0 || j>=n) return Integer.MAX_VALUE;
        if(i==n-1) return matrix[i][j];
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int down = helper(matrix, i+1, j, dp);
        int downleft = helper(matrix, i+1, j-1, dp);
        int downright = helper(matrix, i+1, j+1, dp);

        dp[i][j] = matrix[i][j] + Math.min(down, Math.min(downleft, downright));
        return dp[i][j];
    }
}