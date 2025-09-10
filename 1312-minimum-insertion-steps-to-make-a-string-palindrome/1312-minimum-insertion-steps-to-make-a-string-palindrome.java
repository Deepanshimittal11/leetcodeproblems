class Solution {
    public int minInsertions(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int m = reverse.length();

        int[][] t = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==0 || j==0){
                    t[i][j] = 0;
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==reverse.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return (s.length()-t[n][m]);
    }
}