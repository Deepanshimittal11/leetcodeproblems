class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    public void helper(int i, int[] nums, int target, List<List<Integer>> ans, List<Integer> list){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i == nums.length || target<0){
            return;
        }

        //pick
        list.add(nums[i]);
        helper(i, nums, target-nums[i], ans, list);

        //backtrack
        list.remove(list.size()-1);

        //not pick
        helper(i+1, nums, target, ans, list);
    }
}