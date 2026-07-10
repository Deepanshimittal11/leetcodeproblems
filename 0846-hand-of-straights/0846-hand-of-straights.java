class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize!=0) return false;
        HashMap<Integer, Integer> mpp = new HashMap<>();

        Arrays.sort(hand);
        for(int num : hand){
            mpp.put(num, mpp.getOrDefault(num, 0)+1);
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