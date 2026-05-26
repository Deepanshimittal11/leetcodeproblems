class Solution {
    int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original_color = image[sr][sc];

        if(original_color == color) return image;

        boolean[][] vis = new boolean[image.length][image[0].length];

        dfs(image, sr, sc, original_color, color, vis);

        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int original_color, int color, boolean[][] vis){
        int n = image.length;
        int m = image[0].length;

        image[sr][sc] = color;
        vis[sr][sc] = true;

        for(int[] d : dir){
            int nr = sr + d[0];
            int nc = sc + d[1];
            if(isValid(nr, nc, n, m) && image[nr][nc]==original_color && !vis[nr][nc]){
                dfs(image, nr, nc, original_color, color, vis);
                image[nr][nc] = color;
            } 
        }
    }
    public boolean isValid(int nr, int nc, int n , int m){
        if(nr<n && nc<m && nr>=0 && nc>=0){
            return true;
        }
        return false;
    }
}