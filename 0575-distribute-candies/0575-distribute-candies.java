class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Set<Integer> set = new HashSet<>();
        for(int num : candyType){
            set.add(num);
        }
        if(set.size() >= n/2){
            return n/2;
        }
        else{
            return set.size();
        }
    }
}