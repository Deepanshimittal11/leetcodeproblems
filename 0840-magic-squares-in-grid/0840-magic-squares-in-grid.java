class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int cnt = 0;
        for(int i=0;i<=row-3;i++){
            for(int j=0;j<=col-3;j++){
                if(isMagic(grid, i, j)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public boolean isMagic(int[][] grid, int r, int c){
        // in a 3-3 grid num should be in between 1-9 and unique;
        Set<Integer> set = new HashSet<>();
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(grid[i][j]<1 || grid[i][j]>9 || set.contains(grid[i][j])){
                    return false;
                }else{
                    set.add(grid[i][j]);
                }
            }
        }

        //now we'll see the sum of rows, cols, and diags are equal or not;
        int SUM = grid[r][c] + grid[r][c+1] + grid[r][c+2];
        for(int i=0;i<3;i++){
            if((grid[r+i][c] + grid[r+i][c+1] + grid[r+i][c+2]) != SUM){
                return false;
            }
            else if((grid[r][c+i] + grid[r+1][c+i] + grid[r+2][c+i]) != SUM){
                return false;
            }                
        }

        if((grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2]) != SUM){
            return false;
        }
        if((grid[r+2][c] + grid[r+1][c+1] + grid[r][c+2]) != SUM){
            return false;
        }
        
        return true;
    }
}