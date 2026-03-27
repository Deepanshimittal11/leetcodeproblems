class Solution {
    int[][] dp;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[502][502];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int total = 0;
        for(int i=0;i<n;i++){
            total += piles[i];
        }

        int s1 = solve(0,n-1,piles);
        int s2 = total-s1;
        if(s1>s2) return true;
        return false;
    }
    public int solve(int i, int j, int[] nums){
        if(i>j) return 0;
        if(i==j) return nums[i];
        if(dp[i][j] != -1) return dp[i][j];

        int take_i = nums[i] + Math.min(solve(i+2, j, nums),solve(i+1, j-1,nums));
        int take_j = nums[j] + Math.min(solve(i+1,j-1,nums), solve(i,j-2,nums));
        return dp[i][j] = Math.max(take_i, take_j);
    }
}