class Solution {
    public int minInsertions(String s) {
        int n = s.length()-1;
        int[][] dp = new int[n+1][n+1];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }
        return helper(s, 0, n, dp);
    }
    public int helper(String s, int l, int r, int[][] dp){
        int take = 0;
        int notTake = 0;
        if(l==r) return 0;
        if(dp[l][r] != -1) return dp[l][r];

        if(l < r){
            if(s.charAt(l) == s.charAt(r)){
                take = helper(s, l+1, r-1, dp);
            }
            else{
                notTake = 1 + Math.min(helper(s, l+1,r, dp), helper(s, l, r-1, dp));
            }
        }
        return dp[l][r] = take + notTake ;
    }
}