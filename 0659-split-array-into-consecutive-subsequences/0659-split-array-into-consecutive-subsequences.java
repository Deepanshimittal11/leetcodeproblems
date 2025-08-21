class Solution {
    public boolean isPossible(int[] nums) {
        int n = nums.length;
        
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer,Integer> need = new HashMap<>();

        for(int num : nums){
            cnt.put(num,cnt.getOrDefault(num,0)+1);
        }
        for(int num : nums){
            if(cnt.get(num)==0) continue;
            cnt.put(num,cnt.get(num)-1);
            if(need.getOrDefault(num,0)>0){
                need.put(num,need.get(num)-1);
                need.put(num+1, need.getOrDefault(num+1,0)+1);
            }
            else if(cnt.getOrDefault(num+1,0)>0 && cnt.getOrDefault(num+2,0)>0){
                cnt.put(num+1, cnt.get(num+1)-1);
                cnt.put(num+2, cnt.get(num+2)-1);
                need.put(num+3,need.getOrDefault(num+3,0)+1);
            }
            else{
                return false;
            }
        }
        return true;
    }
}