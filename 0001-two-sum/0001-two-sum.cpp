class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int n = nums.size();
        vector<int> ans;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(nums[i]+nums[j]==target){
        //             ans.push_back(i);
        //             ans.push_back(j);
        //         }
        //     }
        // }

        unordered_map<int, int> mpp;
        for(int i=0;i<n;i++){
            int temp = target-nums[i];
            if(mpp.find(temp) != mpp.end()){
                return {mpp[temp], i};
            }
            mpp[nums[i]] = i;
        }
        return {};
    }
};