class Solution {
    public int maxFrequencyElements(int[] nums) {
        int freq = 0;
        int maxNo = 0;
        Map<Integer, Integer> mpp = new TreeMap<>();
        for(int num : nums){
            mpp.put(num, mpp.getOrDefault(num,0)+1);
            maxNo = Math.max(maxNo, mpp.get(num));
        }
        for(int value : mpp.values()){
            if(value == maxNo){
                freq += value;
            }
        }
        return freq;
    }
}