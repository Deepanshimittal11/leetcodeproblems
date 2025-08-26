class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int n = cards.length;
        int minlen = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int num = cards[i];
            // mpp.put(num, mpp.getOrDefault(num,0)+1);
            if(mpp.containsKey(num)){
                minlen = Math.min(minlen,(i-mpp.get(num)+1));
            }
            mpp.put(num,i);
        }
        return minlen == Integer.MAX_VALUE ? -1 : minlen;
    }
}