class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        generateSubsets(candidates, 0, new ArrayList<>(), result, target, 0);
        return result;
    }

    private void generateSubsets(int[] candidates, int ind, List<Integer> current, List<List<Integer>> result, int target, int s){
        if(s == target){
            result.add(new ArrayList<>(current));
            return ;
        }
        if(s>target || ind==candidates.length){
            return;
        }
        for(int i=ind;i<candidates.length;i++){
            if(i>ind && candidates[i]==candidates[i-1]){
                continue;
            }
            current.add(candidates[i]);
        generateSubsets(candidates, i + 1, current, result, target, s+ candidates[i]); 
        current.remove(current.size()-1);
        }
    }
}