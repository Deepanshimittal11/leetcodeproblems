class Solution {
    int[][] dir = {{-1,0},{0,-1},{0,1},{1,0}};
    int ROW;
    int COL;
    public int latestDayToCross(int row, int col, int[][] cells) {
        ROW = row;
        COL = col;

        int l = 0;
        int r = cells.length-1;
        int lastday = 0; //cnt

        while(l <= r){
            int mid = l + (r-l)/2;
            if(cancross(cells, mid)){
                lastday = mid+1;
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }

        return lastday;
    }
    public boolean cancross(int[][] cells, int mid){
        int[][] adj = new int[ROW][COL];

        for(int i=0;i<=mid;i++){
            int x = cells[i][0]-1;
            int y = cells[i][1]-1;
            adj[x][y] = 1;
        }
        for(int j=0;j<COL;j++){
            if(adj[0][j]==0 && dfs(adj, 0, j)){
                return true;
            }
        }
        return false;
    }
    public boolean dfs(int[][] adj, int i, int j){
        int n = adj.length;
        int m = adj[0].length;

        if(i<0 || j<0 || i>=n || j>=m || adj[i][j]==1) return false;

        //reached at the end
        if(i == ROW-1) return true;

        adj[i][j] = 1;

        for(int[] d : dir){
            int ni = i + d[0];
            int nj = j + d[1];
            if(dfs(adj, ni, nj)) return true;
        }
        return false;
    }
}
