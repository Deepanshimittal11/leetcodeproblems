class Solution {
    public int climbStairs(int n, int[] costs) {
        return helper(0,n, costs);
    }
    public int helper(int i,int n, int[] costs){
        if(i==n) return 0;
        if(i>n) return (int)1e9;

        int mincost = Integer.MAX_VALUE;

        for(int jump=1; jump<=3; jump++){
            int j= i+jump;
            if(j<=n){
                int cost = costs[j-1] + (jump*jump) + helper(j,n,costs);
                mincost = Math.min(mincost, cost);
            }
        }
        return mincost;
    }
}