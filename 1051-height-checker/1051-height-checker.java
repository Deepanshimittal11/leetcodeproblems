class Solution {
    public int heightChecker(int[] heights) {
        int cnt = 0;
        int[] exp = Arrays.copyOf(heights, heights.length);
        Arrays.sort(exp);
        for(int i=0;i<heights.length;i++){
            if(exp[i]!=heights[i]){
                cnt++;
            }
        }
        return cnt;
    }
}