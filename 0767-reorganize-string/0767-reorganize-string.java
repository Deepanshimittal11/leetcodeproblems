class pair{
    char ch;
    int freq ;
    pair(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}
class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> mpp = new HashMap<>();
        // first thing we'll do is to put each character in the map.
        for(char c : s.toCharArray()){
            mpp.put(c, mpp.getOrDefault(c,0)+1);
        }
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> b.freq-a.freq);
        //in this we had transfer map(key,value) to the heap
        //in the form of pair.
        for(Map.Entry<Character, Integer> m : mpp.entrySet()){
            pq.offer(new pair(m.getKey(),m.getValue()));
        }
        //for the final result we'll make stringbuilder.
        StringBuilder sb = new StringBuilder();
        while(pq.size()>1){

            pair firstChar = pq.poll();
            sb.append(firstChar.ch);
            firstChar.freq--;

            pair secChar = pq.poll();
            sb.append(secChar.ch);
            secChar.freq--;

            if(firstChar.freq>0) pq.offer(firstChar);
            if(secChar.freq>0) pq.offer(secChar);
        }
        if(!pq.isEmpty()){
            pair last = pq.poll();
            if(last.freq > 1) return "";
            sb.append(last.ch);
        }
        return sb.toString();
    }
}