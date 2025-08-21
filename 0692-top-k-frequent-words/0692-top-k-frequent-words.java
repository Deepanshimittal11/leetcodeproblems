class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> mpp = new HashMap<>();
        for(String word : words){
            mpp.put(word, mpp.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> {
            int cmp = mpp.get(a).compareTo(mpp.get(b));
            if(cmp==0){
                return b.compareTo(a);
            }
            return cmp;
        });
        for(String word : mpp.keySet()){
            pq.offer(word);
            if(pq.size()>k) pq.poll();
        }
        List<String> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }
}