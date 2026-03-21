class Solution {
public:
    long long maximumSubarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> mpp;
        int l=0;
        long long sum = 0;
        long long maxsum = 0;

        for(int i=0;i<nums.size();i++){
            sum += nums[i];
            mpp[nums[i]]++;
            if(i-l+1 > k){
                sum -= nums[l];
                mpp[nums[l]]--;
                if(mpp[nums[l]]<1) mpp.erase(nums[l]);
                l++;
            }
            if(i-l+1==k && mpp.size()==k){
                maxsum = max(maxsum, sum);
            }
        }
        return maxsum;
    }
};