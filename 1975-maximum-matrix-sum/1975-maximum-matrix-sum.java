class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0;
        int negcnt = 0;
        int minAbs = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int val = matrix[i][j];
                sum += Math.abs(val);
                if(val<0){
                    negcnt++;
                }
                minAbs = Math.min(minAbs, Math.abs(val));                
            }
        }
        if(negcnt%2!=0){
            sum -= 2*minAbs;
        }
        return sum;
    }
}