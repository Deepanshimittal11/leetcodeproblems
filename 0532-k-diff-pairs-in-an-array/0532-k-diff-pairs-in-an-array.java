class Solution {
    public int findPairs(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int num : nums){
            mpp.put(num,mpp.getOrDefault(num,0)+1);
        }
        for(int key : mpp.keySet()){
            if(k==0){
                if(mpp.get(key)>1) cnt++;
            }else{
                if(mpp.containsKey(key+k)) cnt++;
            }
        }
        return cnt;
    }
}