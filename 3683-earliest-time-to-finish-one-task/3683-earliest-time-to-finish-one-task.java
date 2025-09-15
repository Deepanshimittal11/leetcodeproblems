class Solution {
    public int earliestTime(int[][] tasks) {
        int minTime = Integer.MAX_VALUE;
        for(int[] task : tasks){
            int sum = task[0]+task[1];
            minTime = Math.min(minTime, sum);
        }
        return minTime;
    }
}