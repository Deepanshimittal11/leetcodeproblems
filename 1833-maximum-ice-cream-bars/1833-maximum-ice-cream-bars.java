class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int n = costs.length;
        int cnt = 0;

        for(int i=0;i<n;i++){
            if(coins>=costs[i]){
                coins -= costs[i];
                cnt++;
            }
            else{
                return cnt;
            }
        }
        return cnt;
    }
}