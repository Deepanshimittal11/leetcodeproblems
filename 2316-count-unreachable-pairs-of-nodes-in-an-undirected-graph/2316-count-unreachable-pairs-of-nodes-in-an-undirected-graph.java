class Solution {
    ArrayList<ArrayList<Integer>> adj;
    boolean[] vis;
    int cnt;
    public long countPairs(int n, int[][] edges) {
        adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        vis = new boolean[n];
        long ans = 0, total = 0;

        for(int i=0;i<n;i++){
            if(!vis[i]){
                cnt = 0;
                dfs(i);
                ans += (total*cnt);
                total += cnt;
            }
        }
        return ans;
    }
    public void dfs(int node){
        vis[node] = true;
        cnt++;
        for(int it : adj.get(node)){
            if(!vis[it]) dfs(it);
        }
    }
}