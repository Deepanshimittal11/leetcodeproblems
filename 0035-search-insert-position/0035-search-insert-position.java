class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int n = nums.length-1;
        int ans = n;
        if(target>nums[n]){
            return n+1;
        }
        if(target<nums[low]){
            return 0;
        }
        while(low<=high){
            int mid = low+ (high-low)/2;
            if(nums[mid]>=target){
                ans = mid;
                high = mid-1;
            }
            low = mid+1;
        }
        return ans;
    }
}