class Solution {
    public int maxProfit(int[] prices) {
        return helper(prices, 0, 1);
    }
    public int helper(int[] arr, int i, int canbuy){
        if(i >= arr.length) return 0;
        if(canbuy == 1){
            int buy = -arr[i] + helper(arr, i+1, 0);
            int skip = helper(arr, i+1, 1);
            return Math.max(skip, buy);
        }
        else{
            int sell = arr[i] + helper(arr, i+2, 1);
            int hold = helper(arr, i+1, 0);
            return Math.max(hold, sell);
        }
    }
}