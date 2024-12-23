class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroElem = 0;

        for(int i=1;i<nums.length;i++){
            if(nums[i]!=0){
                nums[nonZeroElem] = nums[i];
                if(i!= nonZeroElem){
                    nums[i] = 0;
                }
                nonZeroElem++;
            }
        }
        
    }
}