class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);

        int a = nums[0];
        int b = nums[nums.length-1];

        Map<Integer, Integer> mpp = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            mpp.put(nums[i], mpp.getOrDefault(nums[i],0));
        }
        for(int i=a;i<=b;i++){
            if(!mpp.containsKey(i)){
                ans.add(i);
            }
        }

        return ans;
    }
}