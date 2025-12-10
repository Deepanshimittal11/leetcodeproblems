class Solution {
    boolean[] vis;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        helper(source, adj, destination);
        return vis[source] && vis[destination];
    }
    public void helper(int src, List<List<Integer>> adj, int des){
        vis[src] = true;
        if(vis[des]) return;
        for(int i : adj.get(src)){
            if(!vis[i]) helper(i, adj, des);
        }
    }
}