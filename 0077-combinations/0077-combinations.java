class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        combination(1,1,n,k,list);
        return ans;
    }
    public void combination(int i, int j, int n, int k, List<Integer> list){
        if(j>k){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i>n) return;
        
        //here j is number of positions and i is the number from 1 to n.
        //take
        list.add(i);
        combination(i+1, j+1, n, k, list);
        list.remove(list.size()-1);
        //not take
        combination(i+1, j, n, k, list);
    }
}