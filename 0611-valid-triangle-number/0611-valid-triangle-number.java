class Solution {
    public int triangleNumber(int[] nums) {
        //two sides of a triangle is strictly greater than third side.
        Arrays.sort(nums);
        int cnt = 0;

        for(int c_ind = nums.length-1;c_ind>=2;c_ind--){
            int left = 0;
            int right = c_ind-1;
            while(left<right){
                if(nums[left]+nums[right]> nums[c_ind]){
                    cnt += right-left;
                    right--;
                }else{
                    left++;
                }
            }
        }        
        return cnt;
    }
}