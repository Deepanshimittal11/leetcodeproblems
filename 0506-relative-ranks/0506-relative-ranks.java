class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        int[] scoreCopy = new int[n];
        System.arraycopy(score,0,scoreCopy,0,n);

        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i=0;i<n;i++){
            mpp.put(scoreCopy[i],i);
        }
        Arrays.sort(scoreCopy);

        String[] res = new String[n];
        for(int i=0;i<n;i++){
            if(i==0){
                res[mpp.get(scoreCopy[n-i-1])] = "Gold Medal";
            }
            else if(i==1){
                res[mpp.get(scoreCopy[n-i-1])] = "Silver Medal";
            }
            else if(i==2){
                res[mpp.get(scoreCopy[n-i-1])] = "Bronze Medal";
            }
            else{
                res[mpp.get(scoreCopy[n-i-1])] = Integer.toString(i+1);
            }
        }
        return res;
    }
}