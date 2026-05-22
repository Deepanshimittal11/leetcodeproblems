class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(k, n, 1, 0, 0, ans, new ArrayList<>());
        return ans;
    }
    public void helper(int k, int n, int i, int cnt, int sum, List<List<Integer>> ans, List<Integer> list){
        if(cnt == k && sum == n){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(sum > n){
            return;
        }
        if(i > 9){
            return;
        }

        list.add(i);
        helper(k, n, i+1, cnt+1, sum+i, ans, list);

        list.remove(list.size()-1);

        helper(k, n, i+1, cnt, sum, ans, list);
    }
}