class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int sum = 0;

        int cnt = 0;
        for(int i=n-1;i>=0;i--){
            cnt++;
            if(cnt%3!=0){
                sum += cost[i];
            }
        }
        return sum;
    }
}