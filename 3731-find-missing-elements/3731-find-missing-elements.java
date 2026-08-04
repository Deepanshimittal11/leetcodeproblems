class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int minelem = Integer.MAX_VALUE;
        int maxelem = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i]<minelem){
                minelem = nums[i];
            }
            if(nums[i]>maxelem){
                maxelem = nums[i];
            }
            set.add(nums[i]);
        }

        for(int i=minelem;i<=maxelem;i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}