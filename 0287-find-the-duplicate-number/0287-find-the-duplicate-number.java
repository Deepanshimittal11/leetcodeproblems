class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        // HashMap<Integer,Integer> mpp = new HashMap<>();
        // for(int i=0;i<n;i++){
        //     mpp.put(nums[i], mpp.getOrDefault(nums[i], 0)+1);
        //     if(mpp.get(nums[i]) > 1) return nums[i];
        // }
        // return -1;

        boolean[] isPresent = new boolean[n+1];
        for(int num : nums){
            if(isPresent[num] == true) return num;
            isPresent[num] = true;
        }
        return -1;
    }
}