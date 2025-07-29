class Solution {
    public int maxLength(int[] nums) {
        int maxlen = 0;
        for(int i=0;i<nums.length;i++){
            long pdt = 1;
            int gcd = 0;
            int lcm = 1;
            for(int j=i;j<nums.length;j++){
                pdt *= nums[j];
                gcd = (j==i) ? nums[j] : gcd(gcd,nums[j]);
                lcm = (j==i) ? nums[j] : lcm(lcm,nums[j]);
                if(pdt == (long)gcd*lcm) {                
                    maxlen = Math.max(maxlen, j-i+1);
                }
                if(pdt > 1e18) break;
            }            
        }
        return maxlen;
    }
    private int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    private int lcm(int a, int b){
        return a/gcd(a,b)*b;
    }
}