class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int s=0;
        int ans = 0;
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i=0;i<fruits.length;i++){
            mpp.put(fruits[i],mpp.getOrDefault(fruits[i],0)+1);
            if(mpp.size()>2){
                mpp.put(fruits[s], mpp.getOrDefault(fruits[s],0)-1);
                if(mpp.get(fruits[s])==0){
                    mpp.remove(fruits[s]);
                }
                s++;
            }
            if(mpp.size()<=2){
                ans = Math.max(ans, i-s+1);
            }
        }
        return ans;
    }
}