class DisjointSet {
    int[] parent;
    int[] size;
    // Constructor
    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // initially, each node is its own parent
            size[i] = 1;
        }
    }

    // Find ultimate parent (with path compression)
    public int findParent(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findParent(parent[node]);  // path compression
    }

    // Union by Rank
    public void unionBySize(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv) return;  // already in the same set

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        }else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}
class Solution {
    int[][] dir = {{0,-1},{-1,0},{0,1},{1,0}};
    public int largestIsland(int[][] grid) {
        int  n = grid.length;
        DisjointSet ds = new DisjointSet(n*n); //n*n -> total cells

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0) continue;
                for(int[] d : dir){
                    int ni = i + d[0];
                    int nj = j + d[1];
                    if(isValid(n, ni, nj) && grid[ni][nj]==1){
                        int node = i*n + j;
                        int adjnode = ni*n + nj;
                        ds.unionBySize(node, adjnode);
                    }
                }
            }
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) continue;
                Set<Integer> set = new HashSet<>();
                for(int[] d : dir){
                    int ni = i + d[0];
                    int nj = j + d[1];
                    if(isValid(n, ni, nj) && grid[ni][nj]==1){
                        int adjnode = ni*n + nj;
                        set.add(ds.findParent(adjnode));
                    }
                }
                int max = 1;
                for(int p : set){
                    max += ds.size[p];
                }
                if(max > ans) ans = max;
            }            
        }
    
        for(int i=0;i<n*n;i++){
            ans = Math.max(ans, ds.size[ds.findParent(i)]);
        }
        return ans;
    }
    public boolean isValid(int n, int i, int j){
        if(i>=0 && j>=0 && i<n && j<n) return true;
        return false;
    }
}