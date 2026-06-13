class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0) return new int[0][0];

        int n = intervals.length;
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        ArrayList<int[]> ans = new ArrayList<>();

        int[] curr = intervals[0];
        for(int i=1;i<n;i++){
            if(intervals[i][0] <= curr[1]){
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }
            else{
                ans.add(curr);
                curr = intervals[i];
            }
        }
        ans.add(curr);
        return ans.toArray(new int[ans.size()][]);
    }
}