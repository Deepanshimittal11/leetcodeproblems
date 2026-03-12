class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String , Integer> mpp = new HashMap<>();
        Set<String> set = new HashSet<>();

        for(String st : banned){
            set.add(st);
        }

        paragraph = paragraph.toLowerCase().replaceAll("[^a-z ]", " "); //a-z ke alawa sb replace ho jaege with space.
        for(String str : paragraph.split("\\s+")){
            if(str.length()==0 || set.contains(str)){
                continue;
            }
            mpp.put(str, mpp.getOrDefault(str, 0)+1);
        }

        int max = 0;
        String ans = "";
        for(String freq : mpp.keySet()){
            if(mpp.get(freq) > max) {
                max = mpp.get(freq);
                ans = freq;
            }
        }
        return ans;
    }
}