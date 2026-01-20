class Solution {
    //8 dir
    int[][] dir = {{-1,-1},{-1,1},{1,-1},{1,1},{-1,0},{0,-1},{1,0},{0,1}};
    int m, n;

    //we'll mark alive=-1 & dead=2

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int cnt = helper(i,j,board);
                if(board[i][j]==0){
                    if(cnt==3) board[i][j] = -1;
                }
                else{
                    if(cnt<2 || cnt>3) board[i][j] = 2;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==-1) board[i][j]=1;
                else if(board[i][j]==2) board[i][j]=0;
            }
        }
    }
    public int helper(int i, int j, int[][] board){
        int cnt = 0;

        for(int[] d : dir){
            int ni = i + d[0];
            int nj = j + d[1];
            if(ni>=0 && nj>=0 && ni<m && nj<n){
                if(board[ni][nj]==1 || board[ni][nj]==2){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}