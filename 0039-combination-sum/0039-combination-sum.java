class Solution {
    List<List<Integer>> ans;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return ans;    
    }

    public void helper(int[] candidates, int target, int ind, List<Integer> ds){
        if(ind == candidates.length) return;
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(candidates[ind] <= target){
            ds.add(candidates[ind]);
            helper(candidates, target-candidates[ind], ind, ds);
            ds.remove(ds.size()-1);
        }
        helper(candidates, target, ind+1, ds);
    }
}