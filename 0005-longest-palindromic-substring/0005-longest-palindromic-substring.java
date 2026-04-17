class Solution {
    int[][] dp;
    public String longestPalindrome(String s) {
        dp = new int[1001][1001];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int maxlen = 0, sp = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isPalin(i, j, s)==1){
                    if(j-i+1 > maxlen){
                        maxlen = j-i+1;
                        sp = i;
                    }
                }
            }
        }
        return s.substring(sp, sp+maxlen);
    }
    public int isPalin(int i, int j, String s){
        if(i>=j) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)) return dp[i][j] = isPalin(i+1, j-1, s);
        return dp[i][j] = 0;
    }
}