class Solution {
    public int largestInteger(int num) {

        //it will convert integer into characters.
        char[] digit = String.valueOf(num).toCharArray();

        //max-heap
        PriorityQueue<Integer> pqeven = new PriorityQueue<>((a,b)-> b-a);
        PriorityQueue<Integer> pqodd = new PriorityQueue<>((a,b)-> b-a);

    // put even index elem in even pq & odd index elem in odd pq.
        for(char ch : digit){
            int d = ch - '0';
            if(d%2==0){
                pqeven.add(d);
            }else{
                pqodd.add(d);
            }
        }

    //build the result in string builder.
        StringBuilder str = new StringBuilder();
        for(char ch : digit){
            int d = ch-'0';
            if(d%2==0){
                str.append(pqeven.poll());
            }
            else{
                str.append(pqodd.poll());
            }
        }

        //again convert it into integer.
        return Integer.parseInt(str.toString());
    }
}