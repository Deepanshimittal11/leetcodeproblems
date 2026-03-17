class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = leftmost(nums, target);
        int right = rightmost(nums, target);
        return new int[]{left, right};
    }
    public int leftmost(int[] nums, int target){
        int l = 0;
        int r = nums.length-1;
        int ans = -1;

        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]==target){
                ans = mid;
                r = mid-1;  //move pointer left most to the target
            }
            else if(nums[mid]<target){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return ans;
    }
    public int rightmost(int[] nums, int target){
        int l = 0;
        int r = nums.length-1;
        int ans = -1;
        
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]==target){
                ans = mid;
                l = mid+1; //move pointer right most to the target
            }
            else if(nums[mid]<target){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return ans;
    }
}