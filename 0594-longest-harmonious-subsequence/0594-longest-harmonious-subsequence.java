class Solution {
    public int findLHS(int[] nums) {
        int maxlen = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int num : nums){
            mpp.put(num,mpp.getOrDefault(num,0)+1);
        }
        for(int key : mpp.keySet()){
            if(mpp.containsKey(key+1)){
                maxlen = Math.max(maxlen,mpp.get(key)+mpp.get(key+1));
            }
        }
        return maxlen;
    }
}