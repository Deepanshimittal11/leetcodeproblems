class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n<=2) return n;
        int length = 2;
        for(int i=2;i<n;i++){
            if(nums[i]!=nums[length-2]){
                nums[length] = nums[i];
                length++;
            }
        }
        return length;
    }
}