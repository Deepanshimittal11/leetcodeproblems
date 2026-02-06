class MyHashMap {
    HashMap<Integer, Integer> mpp ;
    public MyHashMap() {
        mpp = new HashMap<>();
    }
    
    public void put(int key, int value) {
        mpp.put(key, value);
    }
    
    public int get(int key) {
        if(mpp.containsKey(key)){
            return mpp.get(key);
        }
        return -1;
    }
    
    public void remove(int key) {
        mpp.remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */