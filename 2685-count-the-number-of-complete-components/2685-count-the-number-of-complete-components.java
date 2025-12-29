class Solution {
    ArrayList<ArrayList<Integer>> adj;
    boolean[] vis;
    int cnt = 0, node = 0, edge = 0;

    public int countCompleteComponents(int n, int[][] edges) {
        adj = new ArrayList<>();
        vis = new boolean[n];

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        for(int i=0;i<n;i++){
            if(!vis[i]){
                node = 0;
                edge = 0;
                dfs(i);
                edge /= 2;
                if(edge == node*(node-1)/2) cnt++;
            }
        }
        return cnt;
    }
    public void dfs(int i){
        vis[i] = true;
        node++;
        edge += adj.get(i).size();

        for(int it : adj.get(i)){
            if(!vis[it]) dfs(it);
        }
    }
}