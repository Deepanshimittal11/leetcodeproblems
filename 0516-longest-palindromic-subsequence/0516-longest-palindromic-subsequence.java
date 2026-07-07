class Solution {
    public int longestPalindromeSubseq(String s1) {
        int n = s1.length()-1;
        StringBuilder str = new StringBuilder();
        for(int i=n;i>=0;i--){
            str.append(s1.charAt(i));
        }
        String s2 = str.toString();

        int m =s2.length()-1;
        int[][] dp = new int[n+1][m+1];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }

        return helper(s1, s2, n, m, dp);
    }
    public int helper(String s1, String s2, int i, int j, int[][] dp){
        int take = 0;
        int notTake = 0;
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j)){
            take = 1 + helper(s1, s2, i-1, j-1, dp);
        }
        else{
            notTake = Math.max(helper(s1, s2, i-1, j, dp), helper(s1, s2, i, j-1, dp));
        }
        return dp[i][j] = (take + notTake);
    }
}