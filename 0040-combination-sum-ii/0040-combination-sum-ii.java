class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        ans = new ArrayList<>();;
        helper(candidates, target, 0, new ArrayList<>());
        return ans;    
    }

    public void helper(int[] candidates, int target, int ind, List<Integer> ds){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=ind; i<candidates.length;i++){
            if(i>ind && candidates[i]==candidates[i-1]) continue;
            if(candidates[i] > target) break;
            ds.add(candidates[i]);
            helper(candidates, target-candidates[i], i+1, ds);
            ds.remove(ds.size()-1);
        }
    }
}