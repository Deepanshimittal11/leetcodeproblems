class Solution {
    public long countSubarrays(int[] nums, int k) {
        long cnt = 0;
        int maxElem = 0;
        int l=0;
        long maxNo = 0;
        for(int num : nums){
            if(num > maxElem) maxElem = num;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==maxElem) cnt++;
            while(cnt >= k){
                if(nums[l]==maxElem) cnt--;
                l++;
            }
            maxNo += l; 
        }
        return maxNo;
    }
}