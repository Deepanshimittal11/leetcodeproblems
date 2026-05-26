class Node{
    int row, col, time;
    Node(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<Node> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0) q.offer(new Node(i, j, 0));
                else mat[i][j] = -1; //univisited.
            }
        }

        while(!q.isEmpty()){
            Node curr = q.poll();
            for(int[] d : dir){
                int nr = d[0] + curr.row;
                int nc = d[1] + curr.col;
                if(isValid(nr, nc, n, m) && mat[nr][nc] == -1){
                    q.offer(new Node(nr, nc, curr.time+1));
                    mat[nr][nc] = curr.time + 1;
                }
            }
        }
        return mat;
    }
    public boolean isValid(int nr, int nc, int n, int m){
        return nr<n && nr>=0 && nc<m && nc>=0;
    }
}