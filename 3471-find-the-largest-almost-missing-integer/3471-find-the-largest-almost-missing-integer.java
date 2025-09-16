class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        //map me elem or uski occurence in an array.
        Map<Integer, Set<Integer>> mpp = new HashMap<>();

        //basically start is a window.
        for(int start = 0;start<n-k+1;start++){

            //j is iterating in one window for start to start+k.
            for(int j=start;j<start+k;j++){
                int num = nums[j];

                //if num is not present in map we'll put it 
                //and make new hash set for it.
                mpp.putIfAbsent(num, new HashSet<>());

                //after putting an elem (num), we add start in set.
                //like 9 appears in subarray 0 and 1.
                // 3 appears in subarray 0.
                mpp.get(num).add(start);
            }
        }
        
        int ans = -1;
        for(int num : mpp.keySet()){
            if(mpp.get(num).size()==1){
                ans = Math.max(ans, num);
            }
        }
        return ans;
    }
}