class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
               return num;
            }
            map.put(num,true);
        }
        return -1;
    }
}