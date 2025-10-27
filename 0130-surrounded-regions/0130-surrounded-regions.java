class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        for(int i=0;i<row;i++){
            dfs(board, i, 0);
            dfs(board, i, col-1);
        }
        for(int j=0;j<col;j++){
            dfs(board, 0, j);
            dfs(board, row-1, j);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){            
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j]=='T'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board, int i, int j){
        int row = board.length;
        int col = board[0].length;

        if(i<0 || j<0 || i>=row || j>=col || board[i][j]!='O') return;

        board[i][j] = 'T';

        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }
}