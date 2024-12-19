class Solution {
    public int maximumWealth(int[][] accounts) {
        //person -- rows;
        //accounts --  cols;
    int ans = Integer.MIN_VALUE;
    for(int[] ints : accounts){
        int sum = 0;
        for(int anInt : ints){
            sum += anInt;
        }
        if(sum > ans){
        ans = sum;
    }
    }    
    return ans;
    }
}