class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        generateSubsets(nums, 0 , new ArrayList<>() ,result);
        return result;
    }

    private void generateSubsets(int[] nums, int ind, List<Integer> current, List<List<Integer>> result){
        if(ind == nums.length){
            result.add(new ArrayList<>(current));
            return ;
        }

        generateSubsets(nums, ind+1,current,result);
        
        current.add(nums[ind]);
        generateSubsets(nums, ind+1,current,result);
        current.remove(current.size()-1);

    }
}