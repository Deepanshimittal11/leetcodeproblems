class Solution {
    ArrayList<String> columnStates = new ArrayList<>();
    int MOD = (int)1e9+7;
    //tabulation b/c in this we cannot do memoization.
    int[][] dp;

    public int colorTheGrid(int m, int n) {
        //step 1: generate column state
        genareateCoumn("", '#', 0, m);
        int totalState = columnStates.size();
        dp = new int[n][totalState];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }

        //step 2: start with columnStates
        int res = 0;
        for(int i=0;i<columnStates.size();i++){
            res = (res+ solve(n-1, i, m)) % MOD;
        }

        //& step 3 : call function solve()
        return res;
    }

    public void genareateCoumn(String curr, char prevChar, int l, int m){
        if(l==m){
            columnStates.add(curr);
            return;
        }
        String color = "RGB";
        for(char ch : color.toCharArray()){
            if(ch == prevChar) continue;
            genareateCoumn(curr+ch, ch, l+1, m);
        }
    }

    public int solve(int remainCols, int prevIdx, int m){
        if(remainCols == 0) return 1;
        if(dp[remainCols][prevIdx] != -1){
            return dp[remainCols][prevIdx];
        }

        int ways = 0;
        String prevState = columnStates.get(prevIdx);

        for(int i=0;i<columnStates.size();i++){
            if(i == prevIdx) continue;
            String currState = columnStates.get(i);

            boolean valid = true;
            for(int j=0;j<m;j++){  //iterating on currState & prevState
                if(prevState.charAt(j) == currState.charAt(j)){
                    valid = false;
                    break;
                    
                }
            }
            if(valid){
                ways = (ways + solve(remainCols-1, i, m)) % MOD;
            }
        }
        return dp[remainCols][prevIdx] = ways;
    }
}