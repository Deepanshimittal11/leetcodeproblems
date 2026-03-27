class Solution {
    int[][][] dp;
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        dp = new int[2][101][101];
        for(int[][] rows : dp){
            for(int[] row : rows){
                Arrays.fill(row, -1);
            }
        }

        return solve(1, 0, 1, piles);  //here 1 is alice and 0 is bob.
    }
    public int solve(int person, int i, int m, int[] nums){
        int n = nums.length;
        if(i>=n) return 0;
        if(dp[person][i][m] != -1) return dp[person][i][m];

        int stones = 0;
        int res = person==1 ? -1 : Integer.MAX_VALUE;

        for(int x=1;x<=Math.min(n-i, 2*m);x++){
            stones += nums[i+x-1];

            if(person == 1){ //if alice turn, she will take max elem.
                res = Math.max(res, stones+solve(0, i+x, Math.max(m, x), nums));
            }
            else{ // now it's a bob turn , he will left min elem for alice.
                res = Math.min(res, solve(1, i+x, Math.max(m,x), nums));
            }
        }
        return dp[person][i][m] = res;
    }
}