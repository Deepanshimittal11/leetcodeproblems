class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> (a[0] - b[0]));

        PriorityQueue<Integer> freeRoom = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            freeRoom.offer(i);
        }

        //min heap [end time, room no.]
        PriorityQueue<int[]> busyRoom = new PriorityQueue<>((a,b) -> a[0]==b[0] ? (a[1]-b[1]) : (a[0]-b[0]));

        int[] cnt = new int[n];

        for(int[] meet : meetings){
            int start = meet[0];
            int end = meet[1];
            int dur = end - start;

            while(!busyRoom.isEmpty() && busyRoom.peek()[0]<=start){
                freeRoom.offer(busyRoom.poll()[1]);
            }

            if(!freeRoom.isEmpty()){
                int room = freeRoom.poll();
                busyRoom.offer(new int[]{end, room});
                cnt[room]++;
            }
            else{
                int[] earliest = busyRoom.poll();
                int newEnd = earliest[0] + dur;
                int room = earliest[1];
                busyRoom.offer(new int[]{newEnd, room});
                cnt[room]++;
            }
        } 

        int max = 0;
        int res = 0;
        for(int i=0;i<n;i++){
            if(cnt[i]>max){
                max = cnt[i];
                res = i;
            }
        }
        return res;
    }
}