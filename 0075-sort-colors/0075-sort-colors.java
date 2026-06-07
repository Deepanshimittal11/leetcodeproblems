class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int mid = 0;

        while(mid<=r){
            if(nums[mid]==2){
                int temp = nums[r];
                nums[r] = nums[mid];
                nums[mid] = temp;
                r--;
            }
            else if(nums[mid]==0){
                int temp = nums[l];
                nums[l] = nums[mid];
                nums[mid] = temp;
                l++;
                mid++;
            }
            else{
                mid++;
            }
        }
    }
}