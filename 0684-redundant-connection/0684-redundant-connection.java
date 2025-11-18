class disjoint{
    int[] parent, rank;
    disjoint(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=0;i<n;i++) parent[i] = i;
    }
    int find(int x){
        if(x != parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }
    void union(int a, int b){
        int pa = find(a), pb = find(b);
        if(pa==pb) return;
        if(rank[pa] < rank[pb]) parent[pa] = pb;
        else if(rank[pa] > rank[pb]) parent[pb] = pa;
        else{
            parent[pa] = pb;
            rank[pa]++;
        }
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        disjoint ds = new disjoint(n);
        int[] ans = new int[2];
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            if(ds.find(u) != ds.find(v)){
                ds.union(u,v);
            }else{
                ans[0] = u;
                ans[1] = v;
            }
        }
        return ans;
    }
}