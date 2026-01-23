class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxcalc = Long.MIN_VALUE;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    long calc = (long)(nums[i]-nums[j])*nums[k];
                    maxcalc = Math.max(maxcalc, calc);
                }
            }
        }
        if(maxcalc<0) return 0;
        return maxcalc;
    }
}