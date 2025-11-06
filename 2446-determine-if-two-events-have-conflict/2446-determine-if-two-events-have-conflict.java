class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int a = event2[0].compareTo(event1[1]);
        int b = event1[0].compareTo(event2[1]);
        return a<=0 && b<=0;
    }
}