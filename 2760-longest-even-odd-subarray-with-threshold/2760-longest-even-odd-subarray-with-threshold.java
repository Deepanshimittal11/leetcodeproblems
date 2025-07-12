class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxlen = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0 && nums[i]<=threshold){
                int len = 1;
                for(int j=i+1;j<n;j++){
                    if(nums[j]>threshold) break;
                    else if(nums[j]%2!=nums[j-1]%2){
                        len++;
                    }
                    else{
                        break;
                    }
                }
                maxlen = Math.max(maxlen,len);
            }
        }
        return maxlen;
    }
}