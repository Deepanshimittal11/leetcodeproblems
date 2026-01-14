class pair{
    char ch;
    int freq;
    pair(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}
class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> mpp = new HashMap<>();
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> b.freq-a.freq);

        for(char c : s.toCharArray()){
            mpp.put(c, mpp.getOrDefault(c,0)+1);
        }
        for(char key : mpp.keySet()){
            pq.offer(new pair(key, mpp.get(key)));
        }

        StringBuilder sb = new StringBuilder();
        while(pq.size()>1){
            pair first = pq.poll();
            pair sec = pq.poll();
            sb.append(first.ch);
            first.freq--;
            sb.append(sec.ch);
            sec.freq--;
            if(first.freq > 0) pq.offer(first);
            if(sec.freq > 0) pq.offer(sec);
        }
        if(!pq.isEmpty()){
            pair node = pq.poll();
            if(node.freq > 1) return "";
            sb.append(node.ch);
        }
        return sb.toString();
    }
}