class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] vis = new int[V];
        int[] pathvis = new int[V];
        int[] check = new int[V];

        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(graph, vis, pathvis, check, i, V);
            }
        }

        List<Integer> safenodes = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(check[i]==1) {
                safenodes.add(i);
            }
        }
        return safenodes;
    }
    public boolean dfs(int[][] graph, int[] vis, int[] pathvis, int[] check, int i, int V){
        vis[i] = 1;
        pathvis[i] = 1;

        for(int newnode : graph[i]){
            if(vis[newnode]==0){
                if(dfs(graph, vis, pathvis, check, newnode, V) == true) return true;
            }
            else if(pathvis[newnode] == 1) return true;
        }
        
        check[i] = 1;
        pathvis[i] = 0;
        return false;
    }
}