class Solution {
    public int findCircleNum(int[][] isConnected) {
        int cnt = 0;
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(isConnected, i, vis);
                cnt++;
            }
        }
        return cnt;
    }
    public void dfs(int[][] isConnected, int ind, boolean[] vis){
        vis[ind] = true;
        for(int i=0;i<isConnected.length;i++){
            if(isConnected[ind][i]==1 && !vis[i]){
                dfs(isConnected, i, vis);
            }
        }
    }
}