class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        //just like a visited arr we'll make color arr and mark every color -1 initially;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i=0;i<n;i++){
            if(color[i] == -1){
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                color[i] = 0; //fill color 0;
                while(!q.isEmpty()){
                    int node = q.poll();
                    for(int neigh : graph[node]){
                        if(color[neigh] == -1){
                            //it means it is not coloured yet
                            color[neigh] = 1 - color[node];//opposite to the color of node like if node coloured with 1 then neigh will be 0 and vice-versa.
                            q.offer(neigh);
                        }else if(color[neigh]==color[node]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}