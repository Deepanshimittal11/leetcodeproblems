class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] rows : dp){
            Arrays.fill(rows, -1);
        }
        return helper(word1, word2, n-1, m-1, dp);
    }
    public int helper(String w1, String w2, int i, int j, int[][] dp){
        int take=0;
        int nottake=0;

        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];

        if(w1.charAt(i)==w2.charAt(j)){
            take = helper(w1,w2,i-1,j-1, dp);
        }
        else{
            nottake = 1 + Math.min(helper(w1,w2,i-1,j-1, dp), Math.min(helper(w1,w2,i-1,j, dp), helper(w1,w2,i,j-1, dp)));
        }
        return dp[i][j] = take+nottake;
    }
}