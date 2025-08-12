class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Arrays.sort(worker);
        int n = profit.length;
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = difficulty[i];
            arr[i][1] = profit[i];
        }
        Arrays.sort(arr, (a,b) -> a[0]-b[0]);
        int maxprofit = 0;
        int index = 0;
        int sum = 0;
        for(int i=0;i<worker.length;i++){
            while(index<n && worker[i]>=arr[index][0]){
                maxprofit = Math.max(maxprofit, arr[index][1]);
                index++;
            }
            sum += maxprofit;
        }
        return sum;
    }
}