class Node{
    int row;
    int col;
    int time;
    Node(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0;
        Queue<Node> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new Node(i, j, 0));
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0) return 0;

        int mintime = 0;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty()){
            Node curr = q.poll();
            for(int[] dis : dir){
                int nr = dis[0] + curr.row;
                int nc = dis[1] + curr.col;
                if(isValid(nr, nc, n, m) && grid[nr][nc]==1){
                    q.offer(new Node(nr, nc, curr.time+1));
                    grid[nr][nc] = 2;
                    fresh--;
                    mintime = curr.time + 1;
                }
            }
        }

        return fresh == 0 ? mintime : -1;
    }
    public boolean isValid(int nr, int nc, int n, int m){
        if(nr<n && nc<m && nr>=0 && nc>=0){
            return true;
        }
        return false;
    }
}