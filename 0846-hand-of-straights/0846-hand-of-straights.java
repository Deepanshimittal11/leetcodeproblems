class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        Map<Integer, Integer> mpp = new HashMap<>();
        if(hand.length % groupSize != 0) return false;
        for(int num : hand){
            mpp.put(num, mpp.getOrDefault(num,0)+1);            
        }
        for(int num : hand){
            if(!mpp.containsKey(num)) continue;
            for(int i=0;i<groupSize;i++){
                int res = num+i;
                if(!mpp.containsKey(res)) return false;
                mpp.put(res, mpp.get(res)-1);
                if(mpp.get(res)<=0) mpp.remove(res);
            }
        }
        return true;
    }
}