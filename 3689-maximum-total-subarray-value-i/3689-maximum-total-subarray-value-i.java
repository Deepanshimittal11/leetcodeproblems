class Solution {
    public long maxTotalValue(int[] nums, int k) {
        
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        long sum = 0;

        for(int num : nums){
            if(num>maxi) maxi = num;
            if(num<mini) mini = num;
        }

        while(k-- > 0){
            sum += maxi-mini;
        }
        return sum;
    }
}