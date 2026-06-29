class Solution {
    int n;
    HashMap<Integer, Integer> mpp;
    Boolean[][] dp = new Boolean[2001][2001];

    public boolean canCross(int[] stones) {
        n = stones.length;
        mpp = new HashMap<>();
        if(stones[1] != 1) return false;

        for(int i=0;i<n;i++){
            mpp.put(stones[i], i);
        }
        return solve(stones, 0, 0);
    }
    public boolean solve(int[] stones, int curr_ind, int prevjump){
        if(curr_ind == n-1) return true;
        if(dp[curr_ind][prevjump] != null) return dp[curr_ind][prevjump];

        boolean res = false;

        for(int jump = prevjump-1; jump<=prevjump+1; jump++){
            if(jump>0){
                int next_stones = stones[curr_ind] + jump;
                if(mpp.containsKey(next_stones)){
                    res = res || solve(stones, mpp.get(next_stones), jump);
                }
            }
        }
        return dp[curr_ind][prevjump] = res;
    }
}