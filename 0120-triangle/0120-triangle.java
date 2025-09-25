class Solution {
    //this is a recursion brute force solution 
    //it will give TLE
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     return func(triangle,0,0);
    // }
    // private int func(List<List<Integer>> triangle, int i, int j){
    //     int n = triangle.size();
    //     if(i==n-1) return triangle.get(i).get(j);
    //     int down = func(triangle,i+1,j) + triangle.get(i).get(j);
    //     int diagonal = func(triangle, i+1, j+1) + triangle.get(i).get(j);
    //     return Math.min(down, diagonal);
    // }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];

        return func(triangle,0,0,dp);
    }
    private int func(List<List<Integer>> triangle, int i, int j, Integer[][] dp){
        int n = triangle.size();

        //base case
        if(i==n-1) return triangle.get(i).get(j);
        if(dp[i][j]!=null) return dp[i][j];

        int down = func(triangle,i+1,j,dp) + triangle.get(i).get(j);
        int diagonal = func(triangle, i+1, j+1,dp) + triangle.get(i).get(j);
        
        dp[i][j] = Math.min(down, diagonal);
        return dp[i][j];
    }
}