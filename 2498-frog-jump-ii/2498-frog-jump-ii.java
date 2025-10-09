class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;
        int maxjump = 0;
        for(int i=0;i+2<n;i++){
            maxjump = Math.max(maxjump, stones[i+2]-stones[i]);
        }   
        maxjump = Math.max(maxjump, stones[1]-stones[0]);     
        return maxjump;
    }
}