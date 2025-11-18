class Node{
    int row, col, time;
    Node(int i, int j, int t){
        row = i;
        col = j;
        time = t;
    }
}
class Solution {
    public boolean isValid(int nr, int nc, int rows, int cols){
        return (nr>=0 && nc>=0 && nr<rows && nc<cols);
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Node> q = new ArrayDeque<>();
        int fresh = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new Node(i,j,0));
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;

        int mintime = 0;
        int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(int[] d : dir){
                int nr = curr.row + d[0];
                int nc = curr.col + d[1];
                if(isValid(nr,nc,n,m) && grid[nr][nc]==1){
                    q.offer(new Node(nr, nc, curr.time+1));
                    grid[nr][nc] = 2;
                    fresh--;
                    mintime = curr.time + 1;
                }
            }
        }
        return (fresh==0) ? mintime : -1;
    }
}