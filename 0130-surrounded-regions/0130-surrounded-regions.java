class Solution {
    int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++){
            if(board[i][0]=='O'){
                dfs(board, i, 0, n, m);
            }
            if(board[i][m-1]=='O'){
                dfs(board, i, m-1, n, m);
            }
        }

        for(int j=0;j<m;j++){
            if(board[0][j]=='O'){
                dfs(board, 0, j, n, m);
            }
            if(board[n-1][j]=='O'){
                dfs(board, n-1, j, n, m);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '1'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board, int i, int j, int n, int m){
        board[i][j] = '1';
        for(int[] d : dir){
            int nr = i + d[0];
            int nc = j + d[1];
            if(isValid(nr, nc, n, m) && board[nr][nc] == 'O'){
                dfs(board, nr, nc, n, m);
            }
        }
    }
    public boolean isValid(int nr, int nc, int n, int m){
        return nr<n && nr>=0 && nc<m && nc>=0;
    }
}