class Solution {
    public int minimumRecolors(String blocks, int k) {
        int cnt=0;
        int n = blocks.length();
        int mincnt = k;
        for(int i=0;i<k;i++){
            if(blocks.charAt(i)== 'W') cnt++;
        }
        mincnt = cnt;
        for(int i=k;i<n;i++){
            if(blocks.charAt(i-k)=='W') cnt--;
            if(blocks.charAt(i)=='W') cnt++;
            mincnt = Math.min(mincnt,cnt);
        }
        return mincnt;
    }
}