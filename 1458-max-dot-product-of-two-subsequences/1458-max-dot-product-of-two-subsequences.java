class Solution {
    int m, n;
    int[][] dp;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;
        dp = new int[501][501];
          
        for(int i=0;i<501;i++){
            for(int j=0;j<501;j++){
                dp[i][j] = -1000000007;
            }
        }      
        return solve(0,0,nums1, nums2);
    }
    public int solve(int i, int j, int[] nums1, int[] nums2){
        if(i==m || j==n) return -1000000007;
        if(dp[i][j] != -1000000007) return dp[i][j];

        int val = nums1[i] * nums2[j];
        int take_ij = nums1[i]*nums2[j] + solve(i+1, j+1, nums1, nums2);
        int take_i = solve(i, j+1, nums1, nums2);
        int take_j = solve(i+1, j, nums1, nums2);

        return dp[i][j] = Math.max(val, Math.max(take_ij, Math.max(take_i, take_j)));
    }
}