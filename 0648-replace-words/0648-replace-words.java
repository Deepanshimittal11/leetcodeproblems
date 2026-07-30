class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>();
        int n = dictionary.size();
        for(int i=0;i<n;i++){
            set.add(dictionary.get(i));
        }
        String[] arr = sentence.split(" ");
        StringBuilder str = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            String s = arr[i];
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<s.length();j++){
                sb.append(s.charAt(j));
                if(set.contains(sb.toString())){
                    str.append(sb);
                    break;
                }
                else if(j==s.length()-1 && !set.contains(sb.toString())){
                    str.append(sb);
                    sb = new StringBuilder();
                }
            }
            if(i<arr.length-1) str.append(" ");
        }
        return str.toString();
    }
}