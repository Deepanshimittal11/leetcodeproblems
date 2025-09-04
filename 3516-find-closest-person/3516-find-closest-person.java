class Solution {
    public int findClosest(int x, int y, int z) {
        int ret1 = Math.abs(z-x);
        int ret2 = Math.abs(z-y);
        if(ret1>ret2){
            return 2;
        }else if(ret2>ret1){
            return 1;
        }
        else{
            return 0;
        }
    }
}