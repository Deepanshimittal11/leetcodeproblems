class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int n = dominoes.length;
        int cnt = 0;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((dominoes[i][0]==dominoes[j][0] && dominoes[i][1]==dominoes[j][1]) || (dominoes[i][0]==dominoes[j][1] && dominoes[i][1]==dominoes[j][0])){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}