class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> y[0]-x[0]);
        //in the 2nd test case , it is given that
        //c=0 so we do not need to include 'c' in it.
        if(a>0) pq.offer(new int[]{a,'a'});
        if(b>0) pq.offer(new int[]{b,'b'});
        if(c>0) pq.offer(new int[]{c,'c'});

        //we want our ans. in string. so use stringbuilder.
        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            int[] topItem = pq.poll();
            int len = sb.length();
            //we can add atmost 2 same char
            if(len>=2 && sb.charAt(len-1)==topItem[1] && sb.charAt(len-2)==topItem[1]){
                if(pq.isEmpty()) break;
                int[] topSec = pq.poll();
                sb.append((char)topSec[1]);
                if(--topSec[0]>0) pq.offer(topSec);
                pq.offer(topItem);
            } else{
                sb.append((char)topItem[1]);
                //if char is more than 2 .
                if(--topItem[0]>0) pq.offer(topItem);
            }
        }
        return sb.toString();
    }
}