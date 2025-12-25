class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);
        long sum = 0;

        for(int i=0;i<k;i++){
            int ind = n - i - 1;
            if(happiness[ind]-i<=0) break;
            sum += happiness[ind] -i;
        }
        return sum;
    }
}