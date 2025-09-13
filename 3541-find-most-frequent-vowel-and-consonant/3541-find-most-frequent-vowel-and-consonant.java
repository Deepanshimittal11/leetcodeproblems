class Solution {
    public int maxFreqSum(String s) {
        Map<Character, Integer> vmap = new HashMap<>();
        int vmaxFreq = 0;
        int cmaxFreq = 0;
        Map<Character, Integer> cmap = new HashMap<>();
        for(char ch : s.toCharArray()){
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                vmap.put(ch, vmap.getOrDefault(ch,0)+1);
                vmaxFreq = Math.max(vmaxFreq, vmap.get(ch));
            }
            else{
                cmap.put(ch, cmap.getOrDefault(ch,0)+1);
                cmaxFreq = Math.max(cmaxFreq, cmap.get(ch));
            }
        }
        return (vmaxFreq+cmaxFreq);
    }
}