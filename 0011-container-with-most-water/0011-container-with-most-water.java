class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l=0, r=n-1;
        int maxA = 0;
        int minH = 0;
        while(l<r){
            int h = Math.min(height[l],height[r]);
            int area = h * (r-l);
            maxA = Math.max(maxA, area);
            if(height[l]<height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxA;
    }
}