class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        //students is a queue;
        // sandwiches is a stack;
        int m = students.length-1;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<=m;i++){
            q.add(students[i]);
        }

        int studentWithoutSandwich = 0;
        int ind = 0;

        while(!q.isEmpty() && studentWithoutSandwich < q.size()){
            if(q.peek() == sandwiches[ind]){
                q.poll();
                ind++;
                studentWithoutSandwich = 0;
            }else{
                q.add(q.poll());
                studentWithoutSandwich++;
            }
        }
        return q.size();
    }
}