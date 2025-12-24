class Solution {
    List<int[]>[] adj;
    int minScore = Integer.MAX_VALUE;
    boolean[] vis;

    public int minScore(int n, int[][] roads) {
        adj = new ArrayList[n+1];
        vis = new boolean[n+1];

        for(int i=0;i<=n;i++) adj[i] = new ArrayList<>();
        for(int[] r : roads){
            adj[r[0]].add(new int[]{r[1],r[2]});
            adj[r[1]].add(new int[]{r[0],r[2]});
        }
        dfs(1, roads, n);
        return minScore;
    }
    public void dfs(int node, int[][] roads, int n){

        vis[node] = true;
        for(int[] it : adj[node]){
            minScore = Math.min(minScore, it[1]);
            if(!vis[it[0]]){
                dfs(it[0], roads, n);                
            }
        }
    }
}