class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<Integer> ds = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[n];
        permutation(nums, freq, ds, ans);
        return ans;
    }
    public void permutation(int[] nums, boolean[] freq, List<Integer> ds, List<List<Integer>> ans){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(nums[i]);
                permutation(nums, freq, ds, ans);
                freq[i] = false;
                ds.remove(ds.size()-1);
            }
        }
    }
}