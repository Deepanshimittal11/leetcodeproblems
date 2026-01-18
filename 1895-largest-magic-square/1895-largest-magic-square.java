class Solution {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] rowsum = new int[n][m];
        for(int i=0;i<n;i++){
            rowsum[i][0] = grid[i][0];
            for(int j=1;j<m;j++){
                rowsum[i][j] = rowsum[i][j-1] + grid[i][j]; 
            }
        }

        int[][] colsum = new int[n][m];
        for(int j=0;j<m;j++){
            colsum[0][j] = grid[0][j];
            for(int i=1;i<n;i++){
                colsum[i][j] = colsum[i-1][j] + grid[i][j];
            }
        }

        for(int side = Math.min(n,m);side>=1;side--){
            for(int i=0;i+side-1<n;i++){
                for(int j=0;j+side-1<m;j++){
                    int target = rowsum[i][j+side-1] - (j>0 ? rowsum[i][j-1] : 0);
                    boolean allsum = true;
                    for(int r=i+1;r<i+side;r++){
                        int sum = rowsum[r][j+side-1] - (j>0 ? rowsum[r][j-1] : 0);
                        if(sum != target){
                            allsum = false;
                            break;
                        }
                    }

                    if(allsum == false) continue;

                    for(int c=j+1;c<j+side;c++){
                        int sum = colsum[i+side-1][c] - (i>0 ? colsum[i-1][c] : 0);
                        if(sum != target){
                            allsum = false;
                            break;
                        }
                    }

                    if(allsum == false) continue;

                    int diag = 0, antidiag = 0;
                    for(int k=0;k<side;k++){
                        diag += grid[i+k][j+k];
                        antidiag += grid[i+k][j+side-1-k];
                    }
                    if(diag==target && antidiag==target) return side;
                }
            }
        }
        return 1;
    }
}