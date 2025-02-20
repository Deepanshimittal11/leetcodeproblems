import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        long sum =0;

        Arrays.sort(happiness);

        for(int i=0;i<k;i++){
            int index = n-1-i;
            if(happiness[i] -i <= 0) break;
            sum += happiness[index]-i;
        }
        return sum;
    }
}