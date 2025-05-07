class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        if(s.length() != t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            char Sch = s.charAt(i);
            map.put(Sch , map.getOrDefault(Sch , 0)+1);
        }
        for(int j=0;j<t.length();j++){
            char Tch = t.charAt(j);
            if(!map.containsKey(Tch)){
                return false;
            }
            map.put(Tch, map.get(Tch)-1);
            if(map.get(Tch)==0){
                map.remove(Tch);
            }
        }

        return map.isEmpty();
    }
}