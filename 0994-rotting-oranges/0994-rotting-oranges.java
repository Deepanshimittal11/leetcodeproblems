class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0; // fresh oranges (1)
        int min = -1;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0; //agr fresh oranges nhi h to return 0;

        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};  //four directions around rotten oranges.

        while(!q.isEmpty()){
            int size = q.size();
            min++;

            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];

                for(int[] d : dir){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr<0 || nc<0 || nr>=row || nc>=col || grid[nr][nc]!=1) continue; //if nr or nc has gone out of boundary.

                    grid[nr][nc] = 2;
                    fresh--;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return (fresh==0) ? min : -1; //if fresh oranges are still left then return -1.
    }
}