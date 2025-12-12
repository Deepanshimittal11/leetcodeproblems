class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        helper(k, n, 1, new ArrayList<>());
        return ans;
    }

    public void helper(int k, int n, int ind, List<Integer> ds){
        if(n==0 && ds.size()==k) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(ds.size()>k || n<0) return;
        for(int i=ind;i<=9;i++){
            ds.add(i);
            helper(k, n-i, i+1, ds);
            ds.remove(ds.size()-1);
        }
    }
}