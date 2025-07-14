class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelset = new HashSet<>();
        for(char c : jewels.toCharArray()){
            jewelset.add(c);
        }
        int cnt = 0;
        for(char c : stones.toCharArray()){
            if(jewelset.contains(c)){
                cnt++;
            }
        }
        return cnt;
    }
}