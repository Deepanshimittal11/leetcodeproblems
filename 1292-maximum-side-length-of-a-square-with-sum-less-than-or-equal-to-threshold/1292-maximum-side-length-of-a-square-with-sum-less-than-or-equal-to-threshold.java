class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;

        int bestSideSq = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int offset=0;offset<Math.min(n-i,m-j);offset++){
                    int r2 = i + offset;
                    int c2 = j + offset;
                    int val = findsum(i,j,r2,c2, mat);
                    if(val <= threshold){
                        bestSideSq = Math.max(bestSideSq, offset + 1);
                    }
                    else{
                        break;
                    }
                }
            }
        }
        return bestSideSq;
    }
    public int findsum(int i, int j, int r2, int c2, int[][] mat){
        int sum = 0;
        for(int row=i;row<=r2;row++){
            for(int col=j;col<=c2;col++){
                sum += mat[row][col];
            }
        }
        return sum;
    }
}