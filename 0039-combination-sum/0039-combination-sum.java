class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generateSubsets(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    private void generateSubsets(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds){
        if(target==0)
            {
                ans.add(new ArrayList<>(ds));
                return;
            }
        if(ind == arr.length){
            return;
        }
        if(arr[ind]<=target){
            ds.add(arr[ind]);
            generateSubsets(ind, arr, target-arr[ind],ans,ds);
            ds.remove(ds.size()-1);
        }
        generateSubsets(ind+1,arr, target,ans,ds);
    }
}