class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        dfs(0, vis, rooms);
        for(int i=0;i<n;i++){
            if(!vis[i]) return false;
        }
        return true;
    }
    public void dfs(int node, boolean[] vis, List<List<Integer>> rooms){
        int m = rooms.size();
        vis[node] = true;
        for(int it : rooms.get(node)){
            if(!vis[it]) dfs(it, vis, rooms);
        }
    }
}