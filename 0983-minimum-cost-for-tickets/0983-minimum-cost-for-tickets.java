class Solution {
    int[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        dp = new int[days.length+1];
        Arrays.fill(dp, -1);
        return helper(days, costs, 0);
    }

    public int helper(int[] days, int[] costs, int index){
        if(index >= days.length) return 0;
        if(dp[index] != -1) return dp[index];

        int cost1 = costs[0] + helper(days, costs, index+1);

        int i = index;
        while(i<days.length && days[i]<days[index]+7){
            i++;
        }
        int cost7 = costs[1] + helper(days, costs, i);

        i = index;
        while(i<days.length && days[i]<days[index]+30){
            i++;
        }
        int cost30 = costs[2] + helper(days, costs, i);

        return dp[index] = Math.min(cost1, Math.min(cost7, cost30));
    }
}