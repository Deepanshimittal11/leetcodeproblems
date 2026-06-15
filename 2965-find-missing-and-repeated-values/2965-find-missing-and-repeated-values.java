class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        int n = grid.length;
        int m = grid[0].length;
        int k = n*m;

        boolean[] isPresent = new boolean[k+1];
        for(int[] nums : grid){
            for(int num : nums){
                if(isPresent[num] == true) ans[0] = num;
                isPresent[num] = true;
            }
        }
        for(int i=1;i<=k;i++){
            if(!isPresent[i]){
                ans[1] = i;
                break;
            }
        }
        return ans;
    }
}