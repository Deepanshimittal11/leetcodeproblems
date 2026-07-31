class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int[] freq = new int[26];
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            freq[ch-'a']++;
        }
        Arrays.sort(freq);

        int cnt = 0;
        int ans = 0;
        int pushes = 1;
        for(int i=25;i>=0;i--){
            //if the last element is zero it means the array is empty so we'll come outside the loop;
            if(freq[i]==0) break;
            
            ans += freq[i]*pushes;
            cnt++;
            if(cnt==8){
                pushes++;
                cnt=0;
            }
        }
        return ans;
    }
}