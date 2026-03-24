class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(n-1, word1, m-1, word2, dp);
    }
    public int helper(int i, String word1, int j, String word2, int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i)==word2.charAt(j)) return dp[i][j] = helper(i-1, word1, j-1, word2, dp);

        return dp[i][j] = 1 + Math.min(helper(i-1, word1, j, word2, dp), Math.min(helper(i, word1, j-1, word2, dp), helper(i-1, word1, j-1, word2, dp)));
    }
}