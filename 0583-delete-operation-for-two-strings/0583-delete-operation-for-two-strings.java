class Solution {
    // public int minDistance(String word1, String word2) {
    //     return helper(word1, word2, 0, 0);
    // }
    // public int helper(String word1, String word2, int i, int j){
    //     if(i == word1.length()) return word2.length()-j;
    //     if(j == word2.length()) return word1.length()-i;
    //     if(word1.charAt(i) == word2.charAt(j)) return helper(word1, word2, i+1, j+1);

    //     int del1 = 1 + helper(word1, word2, i+1, j);
    //     int del2 = 1 + helper(word1, word2, i, j+1);
    //     return Math.min(del1, del2);
    // }


    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];
        for(int[] row : dp) Arrays.fill(row, -1);

        return helper(word1, word2, 0, 0, dp);
    }
    public int helper(String word1, String word2, int i, int j, int[][] dp){
        if(i == word1.length()) return word2.length()-j;
        if(j == word2.length()) return word1.length()-i;
        if(word1.charAt(i) == word2.charAt(j)) return helper(word1, word2, i+1, j+1, dp);
        if(dp[i][j] != -1) return dp[i][j];

        int del1 = 1 + helper(word1, word2, i+1, j, dp);
        int del2 = 1 + helper(word1, word2, i, j+1, dp);
        dp[i][j] = Math.min(del1, del2);
        return dp[i][j];
    }
}