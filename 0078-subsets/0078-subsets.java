class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, ans, new ArrayList<>(), 0);
        return ans;
    }
    public void helper(int[] nums, List<List<Integer>> ans, List<Integer> list, int ind){
        if(ind == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[ind]);
        helper(nums, ans, list, ind+1);

        list.remove(list.size()-1);
        helper(nums, ans, list, ind+1);
    }
}