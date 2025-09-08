class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<n;i++){
            int j = n-i;
            if(nonzero(i)&&nonzero(j)){
                return new int[]{i,j};
            }
        }
        return new int[]{};
    }
    public boolean nonzero(int num){
        while(num>0){
            if(num%10==0) return false;
            num /= 10;
        }
        return true;
    }
}