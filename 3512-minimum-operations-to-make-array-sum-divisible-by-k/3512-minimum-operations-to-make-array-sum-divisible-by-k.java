class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        for(int i : nums){
            sum += i;
        }

        int op = 0;
        if(sum < k) op = sum;
        else{
            if(sum%k==0) op = 0;
            else{
                int rem = sum%k;
                op = rem;
            }
        }
        return op;
    }
}