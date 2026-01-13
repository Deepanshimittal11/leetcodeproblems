class Solution {
    public double separateSquares(int[][] squares) {
        int n = squares.length;
        double totalArea = 0.0;
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;

        for(int[] row : squares){
            int y = row[1];
            int l = row[2];

            totalArea += (double) l*l;
            low = Math.min(low, y);
            high = Math.max(high, y+l);            
        }

        // double res = 0.0;

        while(high-low > 1e-5){
            double mid = low+ (high-low)/2;
            // res = mid;

            if(check(squares, mid, totalArea) == true){
                high = mid;
            }else{
                low = mid;
            }
        }
        return low;
    }
    public boolean check(int[][] square, double mid, double total){
        double bottom_area = 0.0;
        for(int[] sq : square){
            double y = sq[1];
            double l = sq[2];
            double topy = y + l;

            if(mid >= topy){
                bottom_area += l*l;
            }
            else if(mid > y){
                bottom_area += (mid- y)*l;
            }
        }
        return bottom_area >= total/2.0 ;
    }
}