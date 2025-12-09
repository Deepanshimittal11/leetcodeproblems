class Solution {
    int n;
    boolean[] freq;
    List<Integer> ds = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;   
        Arrays.sort(nums); 
        freq = new boolean[n];    
        combination(nums, 0);
        return ans;
    }
    public void combination(int[] nums, int index){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1] && !freq[i-1]) continue;
            if(freq[i]) continue;

            freq[i] = true;
            ds.add(nums[i]);
            combination(nums, i+1);
            ds.remove(ds.size()-1);
            freq[i] = false;
        }
    }
}