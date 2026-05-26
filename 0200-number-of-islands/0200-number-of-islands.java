class Solution {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                    cnt++;
                    dfs(grid, vis, i, j, n, m);
                }
            }
        }
        return cnt;
    }
    public void dfs(char[][] grid, boolean[][] vis, int i, int j, int n, int m){
        vis[i][j] = true;
        for(int[] d : dir){
            int nr = d[0] + i;
            int nc = d[1] + j;
            if(isValid(nr, nc, n, m) && !vis[nr][nc] && grid[nr][nc]=='1'){
                dfs(grid, vis, nr, nc, n, m);
            }
        }
    }
    public boolean isValid(int i, int j, int n, int m){
        return i<n && j<m && i>=0 && j>=0;
    }
}