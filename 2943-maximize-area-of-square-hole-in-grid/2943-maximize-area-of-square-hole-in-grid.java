class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int hlen = 1;
        int vlen = 1;

        int currHbar = 1;
        for(int i=1;i<hBars.length;i++){
            if(hBars[i]-hBars[i-1]==1){
                currHbar++;
            }
            else{
                currHbar = 1;
            }
            hlen = Math.max(currHbar, hlen);
        }

        int currVbar = 1;
        for(int i=1;i<vBars.length;i++){
            if(vBars[i]-vBars[i-1]==1){
                currVbar++;
            }
            else{
                currVbar = 1;
            }
            vlen = Math.max(vlen, currVbar);
        }
        int side = Math.min(hlen, vlen) + 1;
        return side*side;
    }
}