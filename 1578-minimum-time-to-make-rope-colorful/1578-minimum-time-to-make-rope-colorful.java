class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totaltime = 0;
        int prevtime = neededTime[0];
        for(int i=1;i<colors.length();i++){
            if(colors.charAt(i)==colors.charAt(i-1)){
                totaltime += Math.min(prevtime, neededTime[i]);
                prevtime = Math.max(prevtime, neededTime[i]);
            }else{
                prevtime = neededTime[i];
            }
        }
        return totaltime;
    }
}