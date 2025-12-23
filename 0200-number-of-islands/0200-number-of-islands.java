class Solution {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char ch = grid[i][j];
                if(ch == '1' && !vis[i][j]){
                    dfs(i, j, grid, vis);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public void dfs(int i, int j, char[][] grid, boolean[][] vis){
        int n = grid.length;
        int m = grid[0].length;

        vis[i][j] = true;
        for(int[] d : dir){
            int ni = i + d[0];
            int nj = j + d[1];
            if(ni<0 || nj<0 || ni>=n || nj>=m || grid[ni][nj] == '0' || vis[ni][nj]){
                continue;
            }
            dfs(ni, nj, grid, vis);
        }
    }
}