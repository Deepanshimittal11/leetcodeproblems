class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> mpp = new HashSet<>();
        int sum = 0;
        for(int num : nums){
            mpp.add(num);
        }
        for(int num : mpp){
            if(num > 0) sum += num;
        }
        if(sum==0){
            sum = Collections.max(mpp);
        }
        return sum;
    }
}