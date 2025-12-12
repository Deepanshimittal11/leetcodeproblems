class Solution {
    int n, m;
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0) == board[i][j]){
                    if(dfs(0,i,j,board, word)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int ind, int i, int j, char[][] board, String word){
        if(board[i][j] != word.charAt(ind)) return false;
        if(ind == word.length()-1) return true;

        char temp = board[i][j];
        board[i][j] = '#';

        for(int[] dis : dir){
            int ni = i + dis[0];
            int nj = j + dis[1];
            if(ni>=0 && nj>=0 && ni<n && nj<m && board[ni][nj]==word.charAt(ind+1)){
                if(dfs(ind+1, ni, nj, board, word)) return true;
            }
        }
        board[i][j] = temp;
        return false;
    }
}