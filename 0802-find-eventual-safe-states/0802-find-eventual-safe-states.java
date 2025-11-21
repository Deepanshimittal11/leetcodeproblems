class Solution {
    public boolean isCycle(int[][] graph, int i, boolean[] vis, boolean[] isRecursion){
        vis[i] = true;
        isRecursion[i] = true;

        for(int v : graph[i]){
            if(vis[v]==false && isCycle(graph, v, vis, isRecursion)){
                return true;
            }
            else if(isRecursion[v]==true){
                return false;
            }
        }

        isRecursion[i] = false;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean[] vis = new boolean[V];
        boolean[] isRecursion = new boolean[V];

        for(int i=0;i<V;i++){
            if(!vis[i]){
                isCycle(graph, i, vis, isRecursion);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<V;i++){
            if(isRecursion[i] == false){
                ans.add(i);
            }
        }
        return ans;
    }
}