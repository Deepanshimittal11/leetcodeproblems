class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int l=0, r=k-1, cnt=0;
        int sum = 0;
        int avg = 0;
        int n = arr.length;

        for(int i=0;i<k-1;i++) sum += arr[i];

        while(r<n){
            sum += arr[r];
            avg = sum/k;            
            if(avg >= threshold) cnt++;
            r++;
            sum -= arr[l];            
            l++;
        }
        return cnt;
    }
}