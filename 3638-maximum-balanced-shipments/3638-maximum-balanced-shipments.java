class Solution {
    public int maxBalancedShipments(int[] weight) {
        int prev = 0;
        int cnt = 0;
        for(int num : weight){
            if(num < prev){
                cnt++;
                prev = 0;
            }
            else{
                prev = num;
            }
        }
        return cnt;
    }
}