class Solution {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        // return Integer.bitCount(num);  //in built method
        int cnt = 0;
        while(num > 0){
            num = num & (num-1);
            cnt++;
        }
        return cnt;
    }
}