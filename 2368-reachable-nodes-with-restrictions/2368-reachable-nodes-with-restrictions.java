class Solution {
    ArrayList<ArrayList<Integer>> adj;
    boolean[] vis;
    int reachableNodes;
    Set<Integer> set;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        adj = new ArrayList<>();
        vis = new boolean[n];
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        set = new HashSet<>();
        for(int it : restricted) set.add(it);

        reachableNodes = 0;
        
        dfs(0, restricted);
        return reachableNodes;
    }
    public void dfs(int node, int[] restricted){
        if(vis[node] || set.contains(node)) return;
        
        vis[node] = true;
        reachableNodes++;

        for(int it : adj.get(node)){
            dfs(it, restricted);
        }
    }
}