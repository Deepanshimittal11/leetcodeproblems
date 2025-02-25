class Solution {
    public void duplicateZeros(int[] arr) {
        int n= arr.length;
        int cntZeros =0;

        for(int i=0;i<n;i++){
            if(arr[i]==0){
                cntZeros++;
            }
        }

        int i = n-1;
        int j= n-1+cntZeros;

        while(i>=0){
            if(arr[i]==0){
                if(j<n){
                    arr[j] = 0;
                }
                j--;
            }
            if(j<n){
                arr[j]=arr[i];
            }
            i--;
            j--;
        }
    }
}