class pair{
    int num;
    int freq;
    pair(int num, int freq){
        this.num = num;
        this.freq = freq;
    }
}
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {

        Map<Integer, Integer> mpp = new HashMap<>();
        int[] res = new int[barcodes.length];

        for(int barcode : barcodes){
            mpp.put(barcode, mpp.getOrDefault(barcode,0)+1);
        }
        
        PriorityQueue<pair> pq = new PriorityQueue<>((x,y) -> {
            if(x.freq!=y.freq) return y.freq-x.freq;
            else return x.num-y.num;
        });
        
        for(int key : mpp.keySet()){
            pq.offer(new pair(key, mpp.get(key)));
        }
        int i=0;
        while(!pq.isEmpty()){

            pair firstTop = pq.poll();
            res[i++] = firstTop.num;
            firstTop.freq--;

            if(!pq.isEmpty()){
                pair secTop = pq.poll();
                res[i++] = secTop.num;
                secTop.freq--;
                if(secTop.freq>0) pq.offer(secTop);
            }

            if(firstTop.freq>0) pq.offer(firstTop);
        }
        return res;
    }
}