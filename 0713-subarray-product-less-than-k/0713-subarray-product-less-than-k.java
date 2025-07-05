class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l=0, r=0;
        int n = nums.length;
        int pdt = 1, cnt = 0;
        if(k<=1) return 0;
        while(r<n){
            pdt *= nums[r];
            while(pdt >= k){
                pdt /= nums[l];
                l++;
            }
            cnt = cnt + (r-l+1);
            r++;
        }
        return cnt;
    }
}