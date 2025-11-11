class Solution {
    class disjoint{
        int[] par, rank;
        public disjoint(int n){
            par = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++) par[i] = i;
        }
        int find(int x){
            if(x!=par[x]) par[x] = find(par[x]);
            return par[x];
        }
        void union(int a, int b){
            int pa = find(a), pb = find(b);
            if(pa==pb) return;
            if(rank[pa]<rank[pb]) par[pa] = pb;
            else if(rank[pa]>rank[pb]) par[pb] = pa;
            else{
                par[pb] = pa;
                rank[pa]++;
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        disjoint ds = new disjoint(n);

        //union all connection
        for(int[] c : connections){
            ds.union(c[0],c[1]);
        }

        //cnt connected component
        int component = 0;
        for(int i=0;i<n;i++){
            if(ds.find(i)==i) component++;
        }

        return component-1;
    }
}