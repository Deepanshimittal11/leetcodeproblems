class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        helper(nums, list, ans, used);
        return ans;
    }
    public void helper(int[] nums, List<Integer> list, List<List<Integer>> ans, boolean[] used){
        int n = nums.length;

        if(list.size()==n){
            ans.add(new ArrayList<>(list));
        }

        for(int i=0;i<n;i++){
            if(used[i]) continue;

            list.add(nums[i]);
            used[i] = true;

            helper(nums, list, ans, used);

            list.remove(list.size()-1);
            used[i] = false;
        }
        
    }
}