class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totaldrink = numBottles;
        int empty = numBottles;
        while(empty >= numExchange){
            int full = empty/numExchange;
            totaldrink += full;
            empty = empty%numExchange + full;
        }
        return totaldrink; 
    }
}