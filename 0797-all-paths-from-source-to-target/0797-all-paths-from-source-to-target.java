class Solution {
    public void dfs(int[][] graph, List<List<Integer>> ans, List<Integer> path, int currVertex){
        //jo bhi currvertex hoga usko path me add kro.
        path.add(currVertex);

        //agr curr vertex hmari destination point ke equal h to usko ans me add krdo and then backtrack krdo.
        if(currVertex == graph.length-1){
            ans.add(new ArrayList<>(path));
        }
        else{
            for(int x : graph[currVertex]){
                dfs(graph, ans, path, x);
            }
        }
        //backtracking is done in this part.
        path.remove(path.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        //path me hm iteration krvaege (recursion call krege) tb tk jb tk destination point nhi mil jata.
        List<Integer> path = new ArrayList<>();
        dfs(graph, ans, path, 0);
        return ans;
    }
}