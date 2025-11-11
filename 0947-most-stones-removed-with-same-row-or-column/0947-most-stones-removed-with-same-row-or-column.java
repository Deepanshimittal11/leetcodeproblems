class Solution {
    static class disjoint{
        int[] par;
        int[] rank;
        public disjoint(int n){
            par = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++) par[i] = i;
        }
        int find(int x){
            if(x != par[x]) par[x] = find(par[x]);
            return par[x];
        }
        void union(int a, int b){
            int pa = find(a), pb = find(b);
            if(pa==pb) return ;
            if(rank[pa]<rank[pb]) par[pa] = pb;
            else if(rank[pa]>rank[pb]) par[pb] = pa;
            else{
                par[pb] = pa;
                rank[pa]++;
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        disjoint ds = new disjoint(n);

        //connect stones who shares same row or column.
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    ds.union(i,j);
                }
            }
        }

        //cnt unique connected component
        int component = 0;
        for(int i=0;i<n;i++){
            if(ds.find(i)==i) component++;
        }
        return n-component;
    }
}