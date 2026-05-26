class Solution {
    int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++){
            if(grid[i][0]==1){
                dfs(grid, i, 0, n, m);
            }
            if(grid[i][m-1]==1){
                dfs(grid, i, m-1, n, m);
            }
        }
        for(int j=0;j<m;j++){
            if(grid[0][j]==1){
                dfs(grid, 0, j, n, m);
            }
            if(grid[n-1][j]==1){
                dfs(grid, n-1, j, n, m);
            }
        }

        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) cnt++;
            }
        }
        return cnt;
    }
    public void dfs(int[][] grid, int i, int j, int n, int m){
        grid[i][j] = 0;
        for(int[] d : dir){
            int nr = d[0] + i;
            int nc = d[1] + j;
            if(isValid(nr, nc, n, m) && grid[nr][nc]==1){
                dfs(grid, nr, nc, n, m);
            }
        }
    }
    public boolean isValid(int nr, int nc, int n, int m){
        return nr<n && nr>=0 && nc<m && nc>=0;
    }
}