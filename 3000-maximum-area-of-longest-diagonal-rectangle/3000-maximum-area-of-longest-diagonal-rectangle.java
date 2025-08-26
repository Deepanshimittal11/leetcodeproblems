class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiagonal = 0;
        int maxArea = 0;
        for(int i=0;i<dimensions.length;i++){
            int l = dimensions[i][0];
            int b = dimensions[i][1];
            double diagonal = Math.sqrt(l*l+b*b);
            int area = l*b;
            if(diagonal>maxDiagonal){
                maxDiagonal = diagonal;
                maxArea = area;
            }
            else if(maxDiagonal==diagonal){
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }
}