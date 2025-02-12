class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int cnt =0;
        Map<Integer, Integer> mpp = new HashMap<>();
        int[] hash =new int[1000];
        for(int i=0;i<dominoes.length;i++){
            if(dominoes[i][0] > dominoes[i][1]){
                int temp = dominoes[i][0];
                dominoes[i][0] = dominoes[i][1];
                dominoes[i][1] = temp;
            }
            int n = dominoes[i][0]*10 + dominoes[i][1];
            cnt+= hash[n];
            hash[n]++;

        }
        return cnt;
    }
}