class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if(target==0) return true;
        if(target > (x+y)) return false;
        return target % gcd(x,y) == 0;
    }
    private static int gcd(int x, int y){
        while(y != 0){
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}