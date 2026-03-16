class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int n = deck.length;
        int[] ans = new int[n];
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            q.offer(i);
        } 

        // q = [0,1,2,3,4,5,6] => pop 0th ind & push 1 to the last. Repeat the process.
        //num = [2,3,5,7,11,13,17] 
        for(int i=0;i<n;i++){
            int ind = q.poll();
            ans[ind] = deck[i];
            if(!q.isEmpty()){
                q.offer(q.poll());
            } 
        }
        return ans;
    }
}