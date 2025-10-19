class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        return helper(grid, n-1, m-1);
    }
    public int helper(int[][] grid, int i, int j){
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return Integer.MAX_VALUE;

        //left
        int left = helper(grid, i, j-1);
        //up
        int up = helper(grid, i-1, j);
        
        return grid[i][j] + Math.min(left, up);
    }
}