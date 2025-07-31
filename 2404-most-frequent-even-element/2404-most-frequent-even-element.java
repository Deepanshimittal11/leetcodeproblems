class Solution {
    public int mostFrequentEven(int[] nums) {
       Map<Integer, Integer> mpp = new HashMap<>();
       for(int num : nums){
        if(num%2==0){
            mpp.put(num, mpp.getOrDefault(num,0)+1);
        }
       } 
       if(mpp.isEmpty()) return -1;
       int max = 0;
       int res = Integer.MAX_VALUE;
       for(int key : mpp.keySet()){
            int freq = mpp.get(key);
            if(freq>max || (freq==max && key<res)){
                max = freq;
                res = key;
            }
       }
       return res == Integer.MAX_VALUE ? -1 : res;
    }

}