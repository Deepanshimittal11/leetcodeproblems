class Solution {
    public void floydWarshell(long[][] adj, char[] original, char[] changed, int[] cost){
        for(int i=0;i<original.length;i++){
            int s = original[i] - 'a';
            int t = changed[i] - 'a';
            adj[s][t] = Math.min(adj[s][t], (long)cost[i]);
        }

        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(adj[i][k]!=Long.MAX_VALUE && adj[k][j]!= Long.MAX_VALUE){
                        adj[i][j] = Math.min(adj[i][j], adj[i][k]+adj[k][j]);
                    }
                }
            }
        }
    }
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] adj = new long[26][26];
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                adj[i][j] = Long.MAX_VALUE;
                if(i==j) adj[i][j] = 0;
            }
        }

        floydWarshell(adj, original, changed, cost);

        long ans = 0;
        for(int i=0;i<source.length();i++){
            if(source.charAt(i)==target.charAt(i)) continue;
            if(adj[source.charAt(i)-'a'][target.charAt(i)-'a'] == Long.MAX_VALUE){
                return -1;
            }
            ans += adj[source.charAt(i)-'a'][target.charAt(i)-'a'];
        }
        return ans;
    }
}