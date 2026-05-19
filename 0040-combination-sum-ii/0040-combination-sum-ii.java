class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, ans, 0, 0, new ArrayList<>());
        return ans;
    }
    public void helper(int[] candidates, int target, List<List<Integer>> ans, int sum, int ind, List<Integer> list){
        if(sum == target){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(sum > target || ind >= candidates.length){
            return;
        }

        //pick
        list.add(candidates[ind]);
        helper(candidates, target, ans, sum + candidates[ind], ind+1, list);

        //backtrack
        list.remove(list.size()-1);

        //skip duplicates
        while(ind<candidates.length-1 && candidates[ind]==candidates[ind+1]){
            ind++;
        }

        //not pick
        helper(candidates, target, ans, sum, ind+1, list);
    }
}