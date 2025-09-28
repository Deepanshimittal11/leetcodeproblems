class Solution {
    public long maxTotalValue(int[] nums, int k) {

        int n= nums.length;
        int maxi = nums[0];
        int mini = nums[0];
        long sum = 0;

        for(int i=1;i<n;i++){
            if(nums[i]>maxi) maxi = nums[i];
            if(nums[i]<mini) mini = nums[i];
        }

        while(k-- > 0){
            sum += maxi-mini;
        }
        return sum;
    }
}