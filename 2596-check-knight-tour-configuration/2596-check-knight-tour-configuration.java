class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        int[][] pos = new int[n*n][2];

        if(grid[0][0] != 0) return false;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pos[grid[i][j]] = new int[]{i,j};
            }
        }

        int[][] dir = {{-2,-1},{-2,1},{2,-1},{2,1},{-1,-2},{-1,2},{1,-2},{1,2}};

        for(int i=0;i<n*n-1;i++){
            int r1 = pos[i][0], c1 = pos[i][1];
            int r2 = pos[i+1][0], c2 = pos[i+1][1];
            boolean valid = false;

            for(int[] d : dir){
                if(r1+d[0]==r2 && c1+d[1]==c2){
                    valid = true;
                    break;
                }
            }
            if(!valid) return false;
        }
        return true;
    }
}