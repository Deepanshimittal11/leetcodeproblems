class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a,b) ->{
            if(a[1]==b[1]) return b[0]-a[0];
            return a[1]-b[1];
        });

        int cnt = 0;
        //2 elements which we will be selecting are a,b
        int a = -1, b = -1;

        for(int[] in : intervals){
            int start = in[0];
            int end = in[1];
            
            boolean aInside = (a>=start && a<=end);
            boolean bInside = (b>=start && b<=end);

            if(aInside && bInside){
                continue;
            }
            else if(aInside){
                b = a;
                a = end;
                cnt++;
            }
            else{
                b = end-1;
                a = end;
                cnt += 2;
            }
        }
        return cnt;
    }
}