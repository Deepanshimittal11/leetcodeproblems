class Solution {
    //we'll take testcase 
    // 2 3 4 3 1
    // 4 2 2 2 1 
    // 1 2 2 2 1
    // 5 2 2 2 1
    // 6 7 0 1 1 
    //row = 2  and col = 2 will not else every elem = 2 will change
    
    int n , m;
    boolean[][] vis;
    ArrayList<int[]> border;
    int originalcolor;
    int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        n = grid.length;
        m = grid[0].length;
        vis = new boolean[n][m];
        border = new ArrayList<>();

        originalcolor = grid[row][col];
        // grid[row][col] = color;
        dfs(grid, row, col, color);
        for(int[] a : border){
            grid[a[0]][a[1]] = color;
        }
        return grid;
    }
    public void dfs(int[][] grid, int i, int j, int color){
        vis[i][j] = true;
        boolean flag = false;

        for(int[] d : dir){
            int ni = i + d[0];
            int nj = j + d[1];
            if(ni<0 || nj<0 || ni>=n || nj>=m){
                flag = true;
                continue;
            }
            if(grid[ni][nj]!=originalcolor){
                flag = true;
                continue;
            }
            if(!vis[ni][nj]) dfs(grid, ni, nj, color);
        }
        if(flag) border.add(new int[]{i, j});
    }
}