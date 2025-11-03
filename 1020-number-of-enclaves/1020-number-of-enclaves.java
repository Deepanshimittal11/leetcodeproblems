class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        //add all boundary's 1's:
        for(int i=0;i<n;i++){
            if(grid[i][0]==1) q.offer(new int[]{i,0});
            if(grid[i][m-1]==1) q.offer(new int[]{i,m-1});
        }
        for(int j=0;j<m;j++){
            if(grid[0][j]==1) q.offer(new int[]{0,j});
            if(grid[n-1][j]==1) q.offer(new int[]{n-1,j});
        }

        int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};

        while(!q.isEmpty()){
            int[] cell = q.poll();
            int i = cell[0], j=cell[1];

            if(i<0 || j<0 || i>=n || j>=m || grid[i][j]==0) continue;
            grid[i][j]=0;

            for(int[] d : dir){
                int ni = i + d[0];
                int nj = j + d[1];
                q.offer(new int[]{ni,nj});
            }
        }

        int cnt = 0;
        for(int[] row : grid){
            for(int val : row){
                if(val==1) cnt++;
            }
        }
        return cnt;
    }
}