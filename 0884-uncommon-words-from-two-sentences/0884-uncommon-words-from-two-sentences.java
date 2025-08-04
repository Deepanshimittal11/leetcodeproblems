class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> mpp = new HashMap<>();
        for(String word : s1.split(" ")){
            mpp.put(word, mpp.getOrDefault(word,0)+1);
        }
        for(String letter : s2.split(" ")){
            mpp.put(letter, mpp.getOrDefault(letter,0)+1);
        }
        for(String key : mpp.keySet()){
            if(mpp.get(key)==1){
                res.add(key);
            }
        }
        return res.toArray(new String[0]);
    }

}