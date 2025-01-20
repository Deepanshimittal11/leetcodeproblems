class Solution {
    public int findMin(int[] nums) {
        int target = Integer.MAX_VALUE;
        int low =0;
        int high = nums.length-1;
        
        while(low <=high){
            int mid = (low+high)/2;
            if(nums[low] <= nums[mid]){
                target = Math.min(target, nums[low]);
                low = mid+1;
            }
            else{
                target =Math. min(target, nums[mid]);
                high = mid-1;
            }
        }
        return target;
        
    }
}