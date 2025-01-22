class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        
        // while(low<high){
        //     int mid =low+ (high-low)/2;

        //     if(mid>0 && mid< high){
        //         if(nums[mid]> nums[mid-1] && nums[mid]>nums[mid+1]){
        //             return mid;
        //         }
        //         else if(nums[mid]<nums[mid-1]){
        //             high = mid-1;
        //         }
        //         else{
        //             low = mid+1;
        //         }
        //     }
        //     else if(mid == 0 ){
        //         if(nums[mid] > nums[mid+1]){
        //             return mid;
        //         }
        //         else{
        //             return mid+1;
        //         }
        //     }
        //     else{
        //         if(nums[mid] > nums[mid-1]){
        //             return mid;
        //         }
        //         else{
        //             return mid-1;
        //         }
        //     }
        // }
        while(low<high){
            int mid =low+ (high-low)/2;

            if(nums[mid] >= nums[mid+1]){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}