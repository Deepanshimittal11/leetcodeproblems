class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> ans;
        // int n= numRows.size();
        
        for(int row=0;row<numRows;row++){
            vector<int> templis(row+1,1);
            for(int col = 1; col<row ;col++){
                templis[col] = ans[row-1][col-1] + ans[row-1][col];
            }
            ans.push_back(templis);
        }
        return ans;
    }
private:
        int NCR(int n,int row){
            if(row>n) return 0;
            if(row==0 || row==n) return 1;
            int res =1;
            for(int i=1;i<=row;i++){
                res *= (n-(row-i));
                res /= i+1;
            }
            return res;
        }
};