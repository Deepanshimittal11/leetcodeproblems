class Solution {
    //brute force TC = O(n^2)
    // public int maxRotateFunction(int[] nums) {
    //     int maxval = Integer.MIN_VALUE;
    //     int n = nums.length;
    //     if(n==1 || n==0) return 0;

    //     int k = 0;
    //     while(k < n){
    //         int sum = 0;
    //         for(int i=0;i<n;i++){
    //             sum += i * nums[(i+k)%n];
    //         }
    //         maxval = Math.max(maxval, sum);
    //         k++;
    //     }

    //     return maxval;
    // }

    //better sol: TC = O(n)
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        if(n==1 || n==0) return 0;

        int sum = 0;
        int f0 = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            f0 += i * nums[i];
        }

        int maxval = f0;
        int fk = f0;
        for(int k=1;k<n;k++){
            fk += sum - n*nums[n-k];
            maxval = Math.max(maxval, fk);
        }

        return maxval;
    }
}