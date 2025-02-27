class Solution {
public:
    void solve(int col, vector<string> &board,vector<vector<string>> &ans, vector<int> &lr, vector<int> &ld, vector<int> &ud, int n){
        if(col==n){
            ans.push_back(board);
            return; 
        }
        for (int row = 0; row < n; row++) {
            if (lr[row] == 0 && ld[row + col] == 0 && ud[n - 1 - row + col] == 0) {
                board[row][col] = 'Q'; 
                lr[row] = 1;  
                ld[row + col] = 1;
                ud[n - 1 - row + col] = 1; 
                solve(col + 1, board, ans, lr, ld, ud, n); 
                board[row][col] = '.'; 
                lr[row] = 0;  
                ld[row + col] = 0; 
                ud[n - 1 - row + col] = 0;
            }
        }       
    }

    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> ans; 
        vector<string> board(n, string(n, '.'));
        vector<int> lr(n, 0), ud(2 * n - 1, 0), ld(2 * n - 1, 0);  
        solve(0, board, ans, lr, ud, ld, n);  
        return ans;
    }
};