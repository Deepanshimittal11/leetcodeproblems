class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        int[][] vis = new int[row][col];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                }else{
                    vis[i][j] = -1;
                }
            }
        }

        int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr<0 || nc<0 || nr>=row || nc>=col || vis[nr][nc]!=-1) continue;
                vis[nr][nc] = vis[r][c] + 1;
                q.offer(new int[]{nr,nc});
            }            
        }
        return vis;
    }
}