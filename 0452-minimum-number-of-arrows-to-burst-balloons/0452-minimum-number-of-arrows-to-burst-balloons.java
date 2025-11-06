class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        if(n==0) return 0;

        // {1,6},{2,8},{7,12},{10,16}
        Arrays.sort(points, (a,b) -> Integer.compare(a[1],b[1]));

        int lastfinish = points[0][1];
        int arrowscnt = 1;

        for(int i=1;i<points.length;i++){
            if(points[i][0]>lastfinish){
                arrowscnt++;
                lastfinish = points[i][1];
            }
        }
        return arrowscnt;
    }
}