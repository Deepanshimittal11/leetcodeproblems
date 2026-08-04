class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(mpp.containsKey(target-numbers[i])){
                ans[0] = mpp.get(target-numbers[i])+1;
                ans[1] = i+1;
            }
            mpp.put(numbers[i],i);
        }
        return ans;
    }
}