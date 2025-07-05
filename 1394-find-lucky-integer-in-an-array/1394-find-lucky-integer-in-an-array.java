class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int num : arr){
            mpp.put(num, mpp.getOrDefault(num,0)+1);
        }
        int result = -1;
        for(int key : mpp.keySet()){
            if(key == mpp.get(key)){
                result = Math.max(key,result);
            }
        }
        return result;
    }
}