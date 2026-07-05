class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }

        return helper(n-1, text1, m-1, text2, dp);
    }
    public int helper(int i, String text1, int j, String text2, int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int take = 0;
        int notTake = 0;

        if(text1.charAt(i) == text2.charAt(j)){
            take = 1 + helper(i-1, text1, j-1, text2, dp);
        }
        else{
            notTake = Math.max(helper(i-1, text1, j, text2, dp), helper(i, text1, j-1, text2, dp));
        }
        return dp[i][j] = Math.max(take, notTake);
    }
}