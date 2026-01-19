class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] prefix = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                prefix[i][j] =  prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + mat[i-1][j-1];
            }
        }

        int bestSideSq = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int offset=0;offset<Math.min(n-i,m-j);offset++){
                    int r2 = i + offset + 1;
                    int c2 = j + offset + 1;

                    // int val = findsum(i,j,r2,c2, mat);
                    int val = prefix[r2][c2] - prefix[i][c2] - prefix[r2][j] + prefix[i][j];

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
    // public int findsum(int i, int j, int r2, int c2, int[][] mat){
    //     int sum = 0;
    //     for(int row=i;row<=r2;row++){
    //         for(int col=j;col<=c2;col++){
    //             sum += mat[row][col];
    //         }
    //     }
    //     return sum;
    // }
}