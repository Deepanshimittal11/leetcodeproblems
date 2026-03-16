class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;

        //if we do it normal formula:

        // int total = 0;
        // int target = tickets[k];
        // for(int i=0;i<n;i++){
        //     if(i<=k){
        //         total += Math.min(tickets[i], target);
        //     }
        //     else{
        //         total += Math.min(tickets[i], target-1);
        //     }
        // }
        // return total;


        //with queue ds:
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            q.offer(new int[]{tickets[i],i});
        }
        while(true){
            int[] person = q.poll();
            time++;
            person[0]--;

            if(person[0]==0){
                if(person[1]==k) return time;
            }else{
                q.offer(person);
            }
        }
    }
}