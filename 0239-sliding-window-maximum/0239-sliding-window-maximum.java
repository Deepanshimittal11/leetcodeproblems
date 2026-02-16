class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int maxi = 0;
        for(int i=0;i<k;i++){
            if(nums[i]>maxi){
                maxi = nums[i];
            }
        }
        ans[0] = maxi;
        int ind = 1;

        for(int i=k;i<n;i++){
            if(nums[i]>maxi){
                maxi = nums[i];
                ans[ind] = nums[i];
            }
            else{
                ans[ind] = maxi;
            }
            ind++;
        }
        return ans;
    }
}