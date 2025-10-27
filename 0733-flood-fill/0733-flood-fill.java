class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int row = image.length;
        int col = image[0].length;

        int originalcolor = image[sr][sc];
        if(originalcolor == color) return image;
        
        int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});
        image[sr][sc] = color;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
                for(int[] d : dir){
                    int nr = r+d[0];
                    int nc = c+d[1];
                    if(nr<0 || nc<0 || nr>=row || nc>=col || image[nr][nc] != originalcolor) continue;
                    image[nr][nc] = color;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return image;
    }
}